package com.theoxao.base.route.loader

import com.theoxao.base.route.handler.RouteHandler
import com.theoxao.base.persist.model.RouteScript


/**
 * load exist route when project init
 *
 * @author theo
 * @date 2019/5/22
 */

abstract class RouteLoader(private val routeHandler: RouteHandler) {

    protected fun load() {
        routeSupplier()?.forEach {
            routeHandler.addRoute(it)
        }
    }

    abstract fun routeSupplier(): List<RouteScript>?


}
