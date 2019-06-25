package com.theoxao

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.AbstractMongoConfiguration


/**
 * @author theo
 * @date 2019/6/19
 */
@SpringBootApplication
open class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
