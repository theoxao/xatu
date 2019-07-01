package com.theoxao.base.route.loader

import com.theoxao.base.common.GithubConfiguration
import com.theoxao.base.persist.model.GithubData
import com.theoxao.base.persist.model.RouteScript
import com.theoxao.base.route.handler.RouteHandler
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JacksonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.bson.types.ObjectId
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils


/**
 * @author theo
 * @date 2019/6/5
 */
@Component
class GitFileRouteLoader(private val routeHandler: RouteHandler, private val gitConfig: GithubConfiguration) :
    FileRouteLoader(routeHandler) {

    companion object {
        var gitRouteCache: List<RouteScript>? = null
    }

    private val httpClient = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = JacksonSerializer()
        }
        engine {
            maxConnectionsCount = 1000
        }

    }

    init {
        GlobalScope.launch { load() }
    }

    override suspend fun reload() {
        gitRouteCache?.map { it.id }?.forEach { routeHandler.removeRoute(it) }
        load()
    }


    override fun getScriptData(): String {
        return "file from git"
    }

    override suspend fun routeSupplier(): List<RouteScript>? {
        if (StringUtils.isEmpty(gitConfig.git))
            return null
        val packageUrl = buildUrl(gitConfig.path)
        val githubData = fetch(packageUrl)
        gitRouteCache = feedChild(githubData, gitConfig.path)
        return gitRouteCache
    }

    private suspend fun feedChild(parents: List<GithubData>, parentDir: String): List<RouteScript> {
        val routeScripts = mutableListOf<RouteScript>()
        parents.forEach {
            it.relativePath = it.path.removePrefix(gitConfig.path)
            if (it.type == "dir") {
                val path = parentDir + "/" + it.name
                it.child = fetch(buildUrl(path))
                routeScripts.addAll(feedChild(it.child, path))
            } else {
                val record = RouteScript()
                it.content = it.downloadUrl?.let { u -> httpClient.get<String>(u) }
                record.id = ObjectId().toHexString()
                record.content = it.content
                routeScripts.add(record)
            }
        }
        return routeScripts
    }

    private suspend fun fetch(packageUrl: String) = httpClient.get<List<GithubData>>(packageUrl)

    private fun buildUrl(path: String): String {
        return "https://api.github.com/repos/${gitConfig.git.removePrefix("https://github.com/")}" +
                "/contents/$path?ref=${gitConfig.branch}"
    }
}
