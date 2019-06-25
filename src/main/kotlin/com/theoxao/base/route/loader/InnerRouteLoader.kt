package com.theoxao.base.route.loader

import com.theoxao.base.route.handler.RouteHandler
import com.theoxao.base.persist.model.InnerRouteScript
import com.theoxao.base.persist.model.RouteScript
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Component


/**
 * create by theoxao on 2019/5/24
 */
@Component
class InnerRouteLoader(private val mongoTemplate: MongoTemplate, private val routeHandler: RouteHandler) :
    RouteLoader(routeHandler) {
    init {
        load()
    }

    override fun routeSupplier(): List<RouteScript>? =
        mongoTemplate.findAll(InnerRouteScript::class.java) ?: null

}
