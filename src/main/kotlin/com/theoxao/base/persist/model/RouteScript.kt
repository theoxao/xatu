package com.theoxao.base.persist.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


/**
 * @author theo
 * @date 2019/6/19
 */
@Document("route_script")
open class RouteScript : ScriptModel() {
    @Id
    var id = ""

    var uri = "/"

    var requestMethod = "GET"

}
