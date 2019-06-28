package com.theoxao.base.route.loader

import com.theoxao.base.persist.model.InnerRouteScript
import com.theoxao.base.persist.model.RouteScript
import com.theoxao.base.route.handler.RouteHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Component


/**
 * create by theoxao on 2019/5/24
 */
@Component
class InnerRouteLoader(private val mongoTemplate: MongoTemplate, private val routeHandler: RouteHandler) :
    RouteLoader(routeHandler) {
    init {
        GlobalScope.launch { load() }
    }

    override suspend fun routeSupplier(): List<RouteScript>? =
        mongoTemplate.findAll(InnerRouteScript::class.java) ?: null

}
