package com.theoxao.app.model.dto

import com.theoxao.base.persist.model.Trigger

class TriggerDTO {

    var id: String? = ""


    companion object {

        fun fromEntity(trigger: Trigger?): TriggerDTO? {
            trigger ?: return null
            val dto = TriggerDTO()
            dto.id = trigger.id.toHexString()
            return dto
        }
    }

}