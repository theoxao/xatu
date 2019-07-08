package com.theoxao.antlr

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.BailErrorStrategy
import org.antlr.v4.runtime.CommonTokenStream


/**
 * @author theo
 * @date 2019/7/8
 */
class AsyncGroovyParser {

    fun parse(input: String): JavaParser {
        val stream = ANTLRInputStream(input)
        val lexer = JavaLexer(stream)
        val tokenStream = CommonTokenStream(lexer)
        val javaParser = JavaParser(tokenStream)
        javaParser.removeErrorListeners()
        javaParser.errorHandler = BailErrorStrategy()
        return javaParser
    }
}
