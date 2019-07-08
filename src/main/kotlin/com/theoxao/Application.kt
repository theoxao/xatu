package com.theoxao

import com.theoxao.base.persist.model.RouteScript
import com.theoxao.base.route.handler.RouteHandler
import org.bson.types.ObjectId
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.MongoTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement


/**
 * @author theo
 * @date 2019/6/25
 */
@SpringBootApplication
@EnableConfigurationProperties
open class Application {

    private val log = LoggerFactory.getLogger(this.javaClass.name)

    @Bean
    open fun runner(applicationContext: ApplicationContext, routeHandler: RouteHandler): CommandLineRunner {
        return CommandLineRunner {
            val raw = this.javaClass.classLoader.getResource("test_list.groovy")?.readText()
            val record = RouteScript()
            record.id = ObjectId().toHexString()
            record.content = raw!!
            routeHandler.addRoute(record)
        }
    }


    @Bean
    open fun transactionManager(dbFactory: MongoDbFactory): MongoTransactionManager {
        return MongoTransactionManager(dbFactory)
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}


