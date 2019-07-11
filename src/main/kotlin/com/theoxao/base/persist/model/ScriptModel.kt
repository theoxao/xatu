package com.theoxao.base.persist.model

import com.theoxao.base.common.TriggerType
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document


/**
 * @author theo
 * @date 2019/6/19
 */
@Document("script")
open class ScriptModel {

    var id: ObjectId = ObjectId()

    var content: String? = null

    var methodName = "service"

    var app = "system"

    var triggerType: String = TriggerType.HTTP.name

    var triggerId: String? = null

}
