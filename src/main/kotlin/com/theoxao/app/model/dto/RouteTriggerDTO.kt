package com.theoxao.app.model.dto

import com.theoxao.app.model.RouteTrigger
import com.theoxao.base.persist.model.Trigger

class RouteTriggerDTO {

    var id: String? = ""
    var app: String? = ""
    var uri: String? = ""
    var requestMethod = ""


    companion object {

        fun fromEntity(trigger: Trigger?): RouteTriggerDTO? {
            trigger ?: return null
            val routeTrigger = trigger as RouteTrigger
            val dto = RouteTriggerDTO()
            dto.id = routeTrigger.id.toHexString()
            dto.app = routeTrigger.app
            dto.requestMethod = routeTrigger.requestMethod
            dto.uri = routeTrigger.uri
            return dto
        }
    }

}