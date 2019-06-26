package com.theoxao.base.script.ast

import org.codehaus.groovy.GroovyBugError
import org.codehaus.groovy.ast.*
import org.codehaus.groovy.ast.expr.DeclarationExpression
import org.codehaus.groovy.ast.expr.EmptyExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.syntax.Token
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
import org.springframework.transaction.PlatformTransactionManager
import java.util.*


/**
 * @author theo
 * @date 2019/6/26
 */
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
open class TransactionASTTransform : ASTTransformation {

    override fun visit(nodes: Array<out ASTNode>, source: SourceUnit) {
        if (nodes.size != 2 || nodes[0] !is AnnotationNode || nodes[1] !is AnnotatedNode) {
            throw GroovyBugError("Internal error: expecting [AnnotationNode, AnnotatedNode] but got: " + Arrays.asList(*nodes))
        }
        val annotationNode = nodes[0]
        val parent = nodes[1]
        val ast = source.ast
        ast.addImport("PlatformTransactionManager", ClassHelper.make(PlatformTransactionManager::class.java))
        val ve =
            VariableExpression("platformTransactionManager", ClassHelper.make(PlatformTransactionManager::class.java))
        val de = DeclarationExpression(ve, Token.NULL, EmptyExpression())
        val es = ExpressionStatement(de)
        ast.addStatement(es)
        println(source.source.reader.readText())
    }

}
