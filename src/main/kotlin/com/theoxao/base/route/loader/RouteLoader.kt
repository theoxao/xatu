package com.theoxao.base.route.loader

import com.theoxao.base.persist.model.RouteScript
import com.theoxao.base.route.handler.RouteHandler


/**
 * load exist route when project init
 *
 * @author theo
 * @date 2019/5/22
 */

abstract class RouteLoader(private val routeHandler: RouteHandler) {

    suspend fun load() {
        routeSupplier()?.forEach {
            routeHandler.addRoute(it)
        }
    }

    abstract suspend fun routeSupplier(): List<RouteScript>?


}
