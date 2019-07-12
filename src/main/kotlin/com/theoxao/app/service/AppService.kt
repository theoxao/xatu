package com.theoxao.app.service

import com.theoxao.app.model.App
import com.theoxao.app.model.dto.AppDTO
import com.theoxao.common.RestResponse.RestResponse
import com.theoxao.common.RestResponse.withData
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class AppService(private val mongoTemplate: MongoTemplate) {

    fun list(): RestResponse<List<AppDTO>> {
        val list = mongoTemplate.findAll(App::class.java)?.map { it.dto() }?.toList()
        return RestResponse.ok<List<AppDTO>>().withData(list)
    }

    fun add(app: App) {
        mongoTemplate.save(app)
    }

    fun remove(id: String) {
        mongoTemplate.remove(Query.query(Criteria.where("_id").`is`(ObjectId(id))), App::class.java)
    }

}