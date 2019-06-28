package com.thexao.repository.impl

import com.theoxao.base.persist.repository.RouteRepository
import org.springframework.data.mongodb.core.MongoTemplate


/**
 * @author theo
 * @date 2019/6/20
 */
class DefaultRouteRepository(private val mongoTemplate: MongoTemplate) :
    RouteRepository {
}
