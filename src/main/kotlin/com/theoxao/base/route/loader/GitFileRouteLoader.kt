package com.theoxao.base.route.loader

import com.theoxao.base.route.handler.RouteHandler
import org.springframework.stereotype.Component


/**
 * @author theo
 * @date 2019/6/5
 */
@Component
class GitFileRouteLoader(private val routeHandler: RouteHandler) : FileRouteLoader(routeHandler) {

    init {
//        TODO("add a web hook to listen git push event")
    }

    override fun getScriptData(): String {
        return "file from git"
    }

}
