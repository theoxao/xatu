package com.theoxao.base.script

import com.google.common.collect.Maps
import com.theoxao.base.script.antlr.AsyncriptLexer
import com.theoxao.base.script.antlr.AsyncriptParser
import com.theoxao.base.script.antlr.ParamNameListener
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.apache.groovy.util.concurrentlinkedhashmap.ConcurrentLinkedHashMap
import org.springframework.core.ParameterNameDiscoverer
import java.lang.reflect.Constructor
import java.lang.reflect.Method
import java.util.concurrent.ConcurrentHashMap


/**
 * @author theo
 * @date 2019/6/20
 */
class ScriptParamNameDiscoverer(val script: String) : ParameterNameDiscoverer {

    companion object {
        val cache = object : ConcurrentHashMap<String, Array<String>>() {
            override fun put(key: String, value: Array<String>): Array<String>? {
                if (size > 500) {
                    val subList = keys().toList().subList(0, 200)
                    subList.forEach {
                        remove(it)
                    }
                }
                return super.put(key, value)
            }
        }
    }

    private val parser = script.parse()

    override fun getParameterNames(method: Method): Array<String>? {
        var expect = cache[script]
        if (expect != null && expect.isNotEmpty()) {
            return expect
        }
        val compilationUnit = parser.compilationUnit()
        val listener = ParamNameListener()
        ParseTreeWalker.DEFAULT.walk(listener, compilationUnit)
        expect = listener.paramNameList.toTypedArray()
        cache[script] = expect
        return expect
    }

    override fun getParameterNames(ctor: Constructor<*>): Array<String>? = TODO()


    private fun String.parse(): AsyncriptParser {
        val inputStream: CharStream = ANTLRInputStream(this)
        val lexer: TokenSource = AsyncriptLexer(inputStream)
        val tokenStream: TokenStream = CommonTokenStream(lexer)
        val parser = AsyncriptParser(tokenStream)
        parser.removeErrorListeners()
        parser.addErrorListener(DiagnosticErrorListener())
        parser.errorHandler = DefaultErrorStrategy()
        parser.addErrorListener(ConsoleErrorListener())
        return parser
    }
}
