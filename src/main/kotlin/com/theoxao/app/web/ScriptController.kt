package com.theoxao.app.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.app.model.dto.ScriptDTO
import com.theoxao.app.model.vo.RouteScriptVO
import com.theoxao.app.service.ScriptService
import com.theoxao.base.common.Constant
import com.theoxao.common.RestResponse.RestResponse
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/system/script")
class ScriptController(private val scriptService: ScriptService, private val redisTemplate: StringRedisTemplate) {

    private val objectMapper = ObjectMapper()

    @RequestMapping(value = ["/list", ""])
    fun list(app: String): RestResponse<List<ScriptDTO?>> {
        return scriptService.list(app)
    }


    @RequestMapping("/add")
    fun addRouteScript(@RequestBody vo: RouteScriptVO): RestResponse<Unit> {
        val script = scriptService.add(vo)
        redisTemplate.boundValueOps(Constant.ROUTE_DATA_REDIS_PREFIX + script.id)
            .set(objectMapper.writeValueAsString(script))
        return RestResponse.ok()
    }

    @RequestMapping("/update")
    fun updateContent(id: String, content: String) {
        scriptService.updateContent(id, content)
        //TODO
    }

}