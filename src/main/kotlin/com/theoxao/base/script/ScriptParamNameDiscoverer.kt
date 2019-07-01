package com.theoxao.base.script

import org.codehaus.groovy.antlr.SourceBuffer
import org.codehaus.groovy.antlr.UnicodeEscapingReader
import org.codehaus.groovy.antlr.parser.GroovyLexer
import org.codehaus.groovy.antlr.parser.GroovyRecognizer
import org.springframework.core.ParameterNameDiscoverer
import java.io.StringReader
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
        return arrayOf()
    }

    override fun getParameterNames(ctor: Constructor<*>): Array<String>? = TODO()


    private fun String.parse() {
        val ps = getParser()
        val tokenNames = ps.tokenNames
        ps.compilationUnit()
        val ast = ps.ast
    }

    private fun String.getParser(): GroovyRecognizer {
        val sourceBuffer = SourceBuffer()
        val unicodeReader = UnicodeEscapingReader(StringReader(this), sourceBuffer)
        val lexer = GroovyLexer(unicodeReader)
        unicodeReader.setLexer(lexer)
        val parser = GroovyRecognizer.make(lexer)
        parser.setSourceBuffer(sourceBuffer)
        return parser
    }
}
