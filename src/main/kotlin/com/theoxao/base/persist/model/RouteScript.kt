package com.theoxao.base.persist.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


/**
 * @author theo
 * @date 2019/6/19
 */
open class RouteScript {

    var id: String = ""

    var uri = "/"

    var requestMethod = "GET"

    var content: String? = null

    var methodName = "service"

    var app = "system"

}
