package com.theoxao.base.script.ast

import com.theoxao.base.script.ast.JavaNodes.listNode
import com.theoxao.base.script.ast.JavaNodes.stringNode
import org.codehaus.groovy.GroovyException
import org.codehaus.groovy.ast.*
import org.codehaus.groovy.ast.expr.ArrayExpression
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.tools.GenericsUtils
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

    companion object {
        const val PARAMETER_NAMES_FIELD_SUFFIX = "\$parameterNames"
    }

    override fun visit(nodes: Array<out ASTNode>?, source: SourceUnit?) {
        if (nodes == null || nodes.size > 1 || nodes[0] !is ModuleNode) {
            throw GroovyException("something wrong")
        }
        val mn = nodes[0] as ModuleNode
        val firstClass = mn.classes[0]
        mn.methods.forEach {

            val genericsNode = listNode.setGenerics(GenericsType(stringNode))
            val fieldNode =
                FieldNode(
                    "${it.name}$PARAMETER_NAMES_FIELD_SUFFIX",
                    1,
                    GenericsUtils.makeClassSafeWithGenerics(
                        listNode,
                        GenericsType(stringNode)
                    ),
                    null,
                    ArrayExpression(
                        stringNode,
                        it.parameterNames().map { ConstantExpression(it) }
                    )
                )
            firstClass.addField(fieldNode)
        }
    }

    private fun MethodNode.parameterNames(): List<String> {
        return this.parameters.map { it.name }
    }

    private fun ClassNode.setGenerics(node: GenericsType): ClassNode {
        this.genericsTypes = arrayOf(node)
        return this
    }

}
