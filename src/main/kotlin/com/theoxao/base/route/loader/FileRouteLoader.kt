package com.theoxao.base.route.loader

import com.theoxao.base.common.GroovyShellHolder
import com.theoxao.base.route.handler.RouteHandler
import com.theoxao.base.persist.model.RouteScript

abstract class FileRouteLoader(private val routeHandler: RouteHandler) : RouteLoader(routeHandler) {
    abstract override suspend fun routeSupplier(): List<RouteScript>?

    abstract suspend fun reload()

    abstract fun getScriptData(): String

}
