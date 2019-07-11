package com.theoxao.app.service

import com.theoxao.app.model.RouteTrigger
import com.theoxao.app.model.dto.ScriptDTO
import com.theoxao.app.model.dto.TriggerDTO
import com.theoxao.app.model.vo.RouteScriptVO
import com.theoxao.base.persist.model.ScriptModel
import com.theoxao.base.persist.model.Trigger
import com.theoxao.common.RestResponse
import com.theoxao.common.withData
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service

@Service
open class ScriptService(private val mongoTemplate: MongoTemplate) {

    fun list(app: String): RestResponse<List<ScriptDTO?>> {
        val scripts = mongoTemplate.find(Query.query(Criteria.where("app").`is`(app)), ScriptModel::class.java)
            .map { ScriptDTO.fromEntity(it) }
        scripts.forEach {
            it?.let {
                it.trigger = TriggerDTO.fromEntity(mongoTemplate.findById(ObjectId(it.triggerId), Trigger::class.java))
            }
        }
        return RestResponse.ok<List<ScriptDTO?>>().withData(scripts)
    }

    fun add(vo: RouteScriptVO): ScriptModel {
        val trigger = RouteTrigger()
        trigger.uri = vo.uri
        trigger.requestMethod = vo.requestMethod
        trigger.app = vo.app
        trigger.id = ObjectId()
        val script = ScriptModel()
        script.app = vo.app
        script.content = vo.content
        script.methodName = vo.methodName
        script.triggerType = vo.triggerType
        script.triggerId = trigger.id.toHexString()
        mongoTemplate.save(trigger)
        mongoTemplate.save(script)
        return script
    }

    fun updateContent(id: String, content: String): ScriptModel? {
        val update = Update()
        update.set("content", content)
        val script = mongoTemplate.findById(ObjectId(id), ScriptModel::class.java)
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").`is`(id)), update, ScriptModel::class.java)
        return script
    }

}