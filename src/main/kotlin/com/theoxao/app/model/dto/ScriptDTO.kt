package com.theoxao.app.model.dto

import com.theoxao.base.persist.model.ScriptModel

class ScriptDTO {

    var id: String = ""

    var content: String? = null

    var methodName = "service"

    var app = "system"

    var triggerId: String? = null

    var trigger: RouteTriggerDTO? = null


    companion object {
        fun fromEntity(scriptModel: ScriptModel?): ScriptDTO? {
            scriptModel ?: return null
            val dto = ScriptDTO()
            dto.id = scriptModel.id
            dto.content = scriptModel.content
            dto.app = scriptModel.app
            dto.triggerId = scriptModel.triggerId
            dto.methodName = scriptModel.methodName
            return dto
        }
    }
}