package com.theoxao

import com.theoxao.antlr.async.AsyncGroovyListener
import com.theoxao.antlr.async.JavaLexer
import com.theoxao.antlr.async.JavaParser
import com.theoxao.base.common.GroovyShellHolder
import com.theoxao.base.script.js.JsScript
import com.theoxao.base.script.js.JsScriptHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.await
import kotlinx.coroutines.launch
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.BailErrorStrategy
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.codehaus.groovy.runtime.InvokerHelper
import org.graalvm.polyglot.Context
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.MongoTransactionManager
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture


/**
 * @author theo
 * @date 2019/6/25
 */
@SpringBootApplication
@EnableConfigurationProperties
open class Application {


    @Bean
    open fun runner(fooBean: FooBean): CommandLineRunner {
        return CommandLineRunner {
            val jsContext: Context = Context.newBuilder("js").allowAllAccess(true).build()
            val text = this.javaClass.classLoader.getResource("demo.js")?.readText()
            text?.let {
                jsContext.getBindings("js").putMember("fooBean", fooBean)
                jsContext.eval("js", text)
                val member = jsContext.getBindings("js").getMember("result")
                println(member.asString())
            }
            println("-------------------------------------------------------------------------------------------------")
            val pyContext: Context = Context.newBuilder("python").allowAllAccess(true).build()
            val pyText = this.javaClass.classLoader.getResource("demo.py")?.readText()
            text?.let {
                pyContext.getBindings("python").putMember("fooBean", fooBean)
                pyContext.eval("python", pyText)
                val member = pyContext.getBindings("python").getMember("result")
                println(member.asString())
            }
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


@Component
class FooBean {
    var any: String? = "any from bean "

    fun getWhatIWant(): String {
        return "if this is what you want"
    }
}
