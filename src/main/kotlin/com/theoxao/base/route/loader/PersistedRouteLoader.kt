package com.theoxao.base.route.loader

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.base.common.Constant
import com.theoxao.base.route.handler.RouteHandler
import com.theoxao.base.persist.model.RouteScript
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component


/**
 * create by theoxao on 2019/5/24
 */
@Component
class PersistedRouteLoader(private val routeHandler: RouteHandler, private val redisTemplate: StringRedisTemplate) :
    RouteLoader(routeHandler) {

    init {
        load()
    }

    override fun routeSupplier(): List<RouteScript> =
        redisTemplate.keys("${Constant.ROUTE_DATA_REDIS_PREFIX}*").map {
            val routeData = redisTemplate.boundValueOps(it).get()
            ObjectMapper().readValue<RouteScript>(routeData, RouteScript::class.java)
        }

}
