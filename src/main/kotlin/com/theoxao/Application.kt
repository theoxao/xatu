package com.theoxao

import com.theoxao.antlr.AsyncGroovyListener
import com.theoxao.antlr.AsyncGroovyParser
import com.theoxao.antlr.JavaLexer
import com.theoxao.antlr.JavaParser
import com.theoxao.base.script.js.JsScriptHandler
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.BailErrorStrategy
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
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
    open fun runner(jsScriptHandler: JsScriptHandler): CommandLineRunner {
        return CommandLineRunner {
            //            val text = this.javaClass.classLoader.getResource("demo.js")?.readText()
//            text?.let {
//                val js = JsScript(text)
//                jsScriptHandler.function(js)
//                val member = jsScriptHandler.jsContext.getBindings("js").getMember(js.resultName)
//                println(member.asString())
//            }
            val text = this.javaClass.classLoader.getResource("async_java.java")?.readText()!!
            val stream = ANTLRInputStream(text)
            val lexer = JavaLexer(stream)
            val tokenStream = CommonTokenStream(lexer)
            val javaParser = JavaParser(tokenStream)
            javaParser.removeErrorListeners()
            javaParser.errorHandler = BailErrorStrategy()
            val compilationUnit = javaParser.compilationUnit()
            ParseTreeWalker.DEFAULT.walk(AsyncGroovyListener(tokenStream), compilationUnit)
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


