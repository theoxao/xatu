package com.theoxao

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.MongoTransactionManager


/**
 * @author theo
 * @date 2019/6/25
 */
@SpringBootApplication
@EnableConfigurationProperties
open class Application {


    @Bean
    open fun runner(): CommandLineRunner {
        return CommandLineRunner {
            //            val text = this.javaClass.classLoader.getResource("demo.js")?.readText()
//            text?.let {
//                val js = JsScript(text)
//                jsScriptHandler.function(js)
//                val member = jsScriptHandler.jsContext.getBindings("js").getMember(js.resultName)
//                println(member.asString())
//            }

//            val any = parse.invokeMethod("asyncJava", null)

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


