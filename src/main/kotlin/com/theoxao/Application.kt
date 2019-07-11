package com.theoxao

import com.theoxao.antlr.async.AsyncGroovyListener
import com.theoxao.antlr.async.JavaLexer
import com.theoxao.antlr.async.JavaParser
import com.theoxao.base.common.GroovyShellHolder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.await
import kotlinx.coroutines.launch
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.BailErrorStrategy
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.codehaus.groovy.runtime.InvokerHelper
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.MongoTransactionManager
import java.util.concurrent.CompletableFuture


/**
 * @author theo
 * @date 2019/6/25
 */
@SpringBootApplication(scanBasePackages = ["com.theoxao"])
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
            val text = this.javaClass.classLoader.getResource("async_java.java")?.readText()!!
            val stream = ANTLRInputStream(text)
            val lexer = JavaLexer(stream)
            val tokenStream = CommonTokenStream(lexer)
            val javaParser = JavaParser(tokenStream)
            javaParser.removeErrorListeners()
            javaParser.errorHandler = BailErrorStrategy()
            val compilationUnit = javaParser.compilationUnit()
            val listener = AsyncGroovyListener(tokenStream)
            ParseTreeWalker.DEFAULT.walk(listener, compilationUnit)
            val groovy = listener.whatDidYouHear()
            println(groovy)
            val parse = GroovyShellHolder.shell.parse(groovy)
            val parseClass = GroovyShellHolder.shell.classLoader.parseClass(groovy)
            val newInstance = parseClass.newInstance()
            val any = InvokerHelper.invokeMethod(newInstance, "asyncJava", InvokerHelper.EMPTY_ARGS)
//            val any = parse.invokeMethod("asyncJava", null)
            assert(any is CompletableFuture<*>)
            any as CompletableFuture<*>

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


