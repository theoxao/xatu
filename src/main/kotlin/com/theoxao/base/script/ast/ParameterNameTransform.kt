package com.theoxao.base.script.ast

import org.codehaus.groovy.GroovyException
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassHelper.make
import org.codehaus.groovy.ast.FieldNode
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
    override fun visit(nodes: Array<out ASTNode>?, source: SourceUnit?) {
        if (nodes == null || nodes.size > 1 || nodes[0] !is ModuleNode) {
            throw GroovyException("something wrong")
        }
        val mn = nodes[0] as ModuleNode
        val parameterMap = mutableMapOf<String, List<String>>()
        mn.methods.forEach {
            parameterMap[it.name] = it.parameterNames()
        }
        val fieldNode =
            FieldNode("\$parameterNames\$", 1, make(Map::class.java), null, ConstantExpression(parameterMap))
        mn.classes[0].addField(fieldNode)
    }

    private fun MethodNode.parameterNames(): List<String> {
        return this.parameters.map {
            it.name
        }
    }

}
