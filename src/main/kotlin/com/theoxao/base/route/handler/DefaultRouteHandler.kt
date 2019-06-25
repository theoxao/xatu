package com.theoxao.base.route.handler

import com.theoxao.base.common.Constant.ROUTE_DATA_REDIS_PREFIX
import com.theoxao.base.persist.model.RouteScript
import com.theoxao.base.route.RouteCacheService
import com.theoxao.base.script.GroovyScriptService
import com.theoxao.base.script.ScriptParamNameDiscoverer
import com.theoxao.configuration.handlerParam
import io.ktor.application.call
import io.ktor.http.HttpMethod
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.response.respond
import io.ktor.routing.*
import io.ktor.server.engine.ApplicationEngine
import io.ktor.util.AttributeKey
import io.ktor.util.Attributes
import io.ktor.util.KtorExperimentalAPI
import io.ktor.util.pipeline.ContextDsl
import kotlinx.coroutines.future.await
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.javaField


/**
 * create by theoxao on 2019/5/18
 */
@Service
@KtorExperimentalAPI
class DefaultRouteHandler(
    private val applicationEngine: ApplicationEngine,
    private val scriptService: GroovyScriptService,
    private val routeCacheService: RouteCacheService
) : RouteHandler {

    private var baseRoute: Routing? = null

    init {
        val attributes = applicationEngine.application.attributes
        val attribute = attributes.attribute("ApplicationFeatureRegistry") as Attributes
        val route: Any? = attribute.attribute("Routing")
        baseRoute = route as? Routing
    }

    @KtorExperimentalLocationsAPI
    override fun addRoute(routeScript: RouteScript) {
        routeCacheService.routeCache[routeScript.id] = routeScript
        applicationEngine.application.routing {
            markedRoute(routeScript.uri, HttpMethod(routeScript.requestMethod), routeScript.id) {
                handle {
                    val script = scriptService.parse(routeScript.content)
                    val result: Any? = script.invokeMethod(
                        routeScript.methodName,
                        handlerParam(
                            script.metaClass.theClass.methods.find { it.name == routeScript.methodName }!!,
                            ScriptParamNameDiscoverer(routeScript.content)
                        ).params.map { it.value }.toTypedArray()
                    )
                    call.respond(
                        when (result) {
                            is Unit -> throw RuntimeException("script should not return unit")
                            is CompletableFuture<*> -> result.await()
                            else -> result!!
                        }
                    )
                }
            }
        }
    }

    override fun removeRoute(id: String) {
        baseRoute?.childList()!!.forEach { parent ->
            val grandChildList = parent.childList()
            grandChildList.removeIf {
                val keys = it.attributes.allKeys.filter { ti -> ti.name == id }
                if (keys.isNotEmpty()) {
                    val key = keys[0] as? AttributeKey<String>
                    return@removeIf if (key != null) it.attributes.getOrNull(key) == id else false
                }
                false
            }
        }

    }
}


/**
 * use reflect to get childList since its private
 */
fun Route.childList(): MutableList<Route> {
    val field =
        Route::class.declaredMemberProperties.stream().filter { it.name == "childList" }.findAny().get().javaField
    field?.isAccessible = true
    return field?.get(this) as MutableList<Route>
}

internal val identifyKey = AttributeKey<String>("ID")

/**
 * add a id attribute to route
 */
@ContextDsl
fun Route.markedRoute(path: String, method: HttpMethod, value: String, build: Route.() -> Unit): Route {
    val selector = HttpMethodRouteSelector(method)
    val createRouteFromPath = createRouteFromPath(path)
    val child = createRouteFromPath.createChild(selector)
    child.attributes.put(AttributeKey<String>(value), ROUTE_DATA_REDIS_PREFIX + value)
    return child.apply(build)
}

fun Attributes.attribute(key: String): Any? {
    val keys = this.allKeys.filter { it.name == key }
    if (keys.isNotEmpty()) {
        return this.getOrNull(keys[0] as AttributeKey<Attributes>)
    }
    return null
}
