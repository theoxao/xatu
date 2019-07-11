package com.theoxao.base.persist.model

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

@Document("trigger")
open class Trigger {

    var id: ObjectId = ObjectId()

    var app: String? = null

}