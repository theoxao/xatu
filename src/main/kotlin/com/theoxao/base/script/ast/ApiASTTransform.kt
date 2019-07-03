package com.theoxao.base.script.ast

import com.theoxao.base.script.ast.JavaNodes.stringNode
import com.theoxao.base.script.ast.JavaNodes.metaApiNode
import org.codehaus.groovy.GroovyBugError
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.AnnotatedNode
import org.codehaus.groovy.ast.AnnotationNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation


/**
 * @author theo
 * @date 2019/6/27
 */
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class ApiASTTransform : ASTTransformation {
    companion object {
        const val API_META_FIELD_NAME = "apiMeta\$string"
        const val API_META_OBJECT_NAME = "metaApi\$object"
    }

    override fun visit(nodes: Array<out ASTNode>, source: SourceUnit) {
        if (nodes.size != 2 || nodes[0] !is AnnotationNode || nodes[1] !is AnnotatedNode) {
            throw GroovyBugError("Internal error: expecting [AnnotationNode, AnnotatedNode] but got: " + listOf(*nodes))
        }
        val apiNode = nodes[0] as AnnotationNode
        val methodNode = nodes[1] as MethodNode
        val uri = apiNode.members["uri"]!!.text
        val method = methodNode.name
        val requestMethod = apiNode.members["requestMethod"]?.text ?: "GET"
        methodNode.declaringClass.addProperty(
            API_META_FIELD_NAME, 1, stringNode,
            ConstantExpression(MetaApi(uri, method, requestMethod).toString()), null, null
        )
        methodNode.declaringClass.addProperty(
            API_META_OBJECT_NAME, 1, metaApiNode, null, null, null
        )
    }
}
