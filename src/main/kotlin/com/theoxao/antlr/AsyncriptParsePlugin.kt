package com.theoxao.antlr

import org.codehaus.groovy.antlr.AntlrParserPlugin
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.syntax.Reduction
import java.io.Reader


/**
 * @author theo
 * @date 2019/6/25
 */
class AsyncriptParsePlugin : AntlrParserPlugin() {

    override fun parseCST(sourceUnit: SourceUnit?, reader: Reader?): Reduction {

        return super.parseCST(sourceUnit, reader)
    }
}
