package com.theoxao.tmp

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.base.common.Constant.ROUTE_DATA_REDIS_PREFIX
import com.theoxao.base.persist.model.RouteScript
import com.theoxao.base.route.handler.RouteHandler
import org.bson.types.ObjectId
import org.intellij.lang.annotations.Language
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class RouteController(private val redisTemplate: StringRedisTemplate) {

    private val objectMapper: ObjectMapper = ObjectMapper()

    @RequestMapping("add")
    fun foo(): String {
        @Language("Groovy")
        val raw = "static service(String name){\n    return name.reverse()\n}"
        val record = RouteScript()
        record.id = ObjectId().toHexString()
        record.uri = "/bar"
        record.content = raw
        redisTemplate.boundValueOps(ROUTE_DATA_REDIS_PREFIX + record.id)
            .set(objectMapper.writeValueAsString(record))
        return "success"
    }

}
