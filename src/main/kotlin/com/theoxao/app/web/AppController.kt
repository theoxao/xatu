package com.theoxao.app.web

import com.theoxao.app.model.App
import com.theoxao.app.model.dto.AppDTO
import com.theoxao.app.service.AppService
import com.theoxao.common.RestResponse.RestResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/system/app")
class AppController(private val appService: AppService) {

    @GetMapping(value = ["", "/list"])
    fun list(): RestResponse<List<AppDTO>> {
        return appService.list()
    }

    @PostMapping("add")
    fun add(name: String, desc: String?): RestResponse<Unit> {
        //todo save image
        appService.add(App(name, desc, ""))
        return RestResponse.ok()
    }

    @PostMapping("del")
    fun remove(id: String): RestResponse<Unit> {
        appService.remove(id)
        return RestResponse.ok()
    }


}