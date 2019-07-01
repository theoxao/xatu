package com.theoxao.base.script.antlr

import groovyjarjarantlr.debug.ParserAdapter
import groovyjarjarantlr.debug.ParserListener
import groovyjarjarantlr.debug.TraceEvent


/**
 * @author theo
 * @date 2019/7/1
 */
class ScriptParamNameParseListener : ParserAdapter() {
    override fun enterRule(te: TraceEvent) {
        println(te.type)
    }
}
