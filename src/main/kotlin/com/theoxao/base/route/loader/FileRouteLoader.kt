package com.theoxao.base.route.loader

import com.theoxao.base.common.GroovyShellHolder
import com.theoxao.base.route.handler.RouteHandler
import com.theoxao.base.persist.model.RouteScript

abstract class FileRouteLoader(private val routeHandler: RouteHandler) : RouteLoader(routeHandler) {
    override fun routeSupplier(): List<RouteScript>? {
        val script = GroovyShellHolder.shell.parse(getScriptData())
        //FILLME
        return null
    }

    abstract fun getScriptData(): String

}
