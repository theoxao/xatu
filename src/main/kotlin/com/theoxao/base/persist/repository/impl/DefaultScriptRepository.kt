package com.theoxao.base.persist.repository.impl

import com.theoxao.base.persist.model.ScriptModel
import com.theoxao.base.persist.repository.ScriptRepository
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository


/**
 * @author theo
 * @date 2019/6/20
 */
@Repository
open class DefaultScriptRepository(private val mongoTemplate: MongoTemplate) :
    ScriptRepository {
    override fun findById(id: String): ScriptModel? {
        return mongoTemplate.findById(ObjectId(id), ScriptModel::class.java)
    }
}
