package com.theoxao.antlr

import org.codehaus.groovy.control.ParserPlugin
import org.codehaus.groovy.control.ParserPluginFactory


/**
 * @author theo
 * @date 2019/6/25
 */
class AsyncriptParsePluginFactory : ParserPluginFactory() {
    override fun createParserPlugin(): ParserPlugin {
        return AsyncriptParsePlugin()
    }
}
