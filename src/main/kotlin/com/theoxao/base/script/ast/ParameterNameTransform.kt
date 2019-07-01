package com.theoxao.base.script.ast

import org.codehaus.groovy.GroovyException
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassHelper.make
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.ModuleNode
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation


/**
 * @author theo
 * @date 2019/7/1
 */
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class ParameterNameTransform : ASTTransformation {
    override fun visit(nodes: Array<out ASTNode>?, source: SourceUnit) {
        if (nodes == null || nodes.size > 1 || nodes[0] !is ModuleNode) {
            throw GroovyException("something wrong")
        }
        val mn = nodes[0] as ModuleNode
        val parameterMap = mutableMapOf<String, String>()
        val firstClass = mn.classes[0]
        mn.methods.forEach {
            firstClass.addField(
                it.name + "\$parameterNames",
                1,
                make(String::class.java),
                ConstantExpression(it.parameterNames())
            )
        }
    }

    private fun MethodNode.parameterNames(): String {
        return this.parameters.joinToString(",") { it.name }
    }

}
