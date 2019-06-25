package com.theoxao.base.route

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.base.common.Constant.ROUTE_DATA_REDIS_PREFIX
import com.theoxao.base.persist.model.RouteScript
import com.theoxao.base.persist.model.ScriptModel
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import org.springframework.util.Assert
import java.util.concurrent.ConcurrentHashMap


/**
 * @author theo
 * @date 2019/5/23
 */
@Service
class RouteCacheService(private val redisTemplate: StringRedisTemplate) {

    val routeCache = ConcurrentHashMap<String, RouteScript>()

    fun updateScript(id: String, scriptId: String) {
        Assert.isTrue(routeCache.containsKey(id), "route does not exist")
        val raw = redisTemplate.boundValueOps(ROUTE_DATA_REDIS_PREFIX + id).get()
        val objectMapper = ObjectMapper()
        val data = objectMapper.readValue<RouteScript>(raw, RouteScript::class.java)
        redisTemplate.boundValueOps(ROUTE_DATA_REDIS_PREFIX + id).set(objectMapper.writeValueAsString(data))
    }

    fun getScript() {

    }
}
