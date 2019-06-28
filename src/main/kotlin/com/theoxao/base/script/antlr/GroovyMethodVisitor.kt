package com.theoxao.base.script.antlr

import org.codehaus.groovy.antlr.GroovySourceAST
import org.codehaus.groovy.antlr.treewalker.VisitorAdapter


/**
 * @author theo
 * @date 2019/6/28
 */
class GroovyMethodVisitor : VisitorAdapter() {
    override fun visitMethodDef(t: GroovySourceAST?, visit: Int) {
        super.visitMethodDef(t, visit)
    }
}
