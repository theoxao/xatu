package com.theoxao.base.route.handler

import com.theoxao.base.persist.model.RouteScript


/**
 * create by theoxao on 2019/5/18
 */

interface RouteHandler {
    fun addRoute(routeScript: RouteScript)

    fun removeRoute(id: String)
}
