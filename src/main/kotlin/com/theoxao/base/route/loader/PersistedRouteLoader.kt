package com.theoxao.base.route.loader

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.app.model.RouteTrigger
import com.theoxao.base.common.Constant
import com.theoxao.base.persist.model.RouteScript
import com.theoxao.base.persist.model.ScriptModel
import com.theoxao.base.route.handler.RouteHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component


/**
 * create by theoxao on 2019/5/24
 */
@Component
class PersistedRouteLoader(
    routeHandler: RouteHandler,
    private val redisTemplate: StringRedisTemplate,
    private val mongoTemplate: MongoTemplate
) : RouteLoader(routeHandler) {

    init {
        GlobalScope.launch { load() }
    }

    override suspend fun routeSupplier(): List<RouteScript> {
        val list = redisTemplate.keys("${Constant.ROUTE_DATA_REDIS_PREFIX}*").map {
            val routeData = redisTemplate.boundValueOps(it).get()
            ObjectMapper().readValue<ScriptModel>(routeData, ScriptModel::class.java)
        }
        val map = list.associateBy { it.triggerId }
        val keys = map.keys.map { ObjectId(it) }
        val triggers = mongoTemplate.find(Query.query(Criteria.where("_id").`in`(keys)), RouteTrigger::class.java)
        return triggers.map {
            val route = RouteScript()
            val scriptModel = map[it.id.toHexString()]
            route.uri = it.uri
            route.requestMethod = it.requestMethod
            route.app = it.app
            route.content = scriptModel?.content
            route.methodName = scriptModel?.methodName ?: "service"
            route.id = it.id.toHexString()
            route
        }
    }

}
