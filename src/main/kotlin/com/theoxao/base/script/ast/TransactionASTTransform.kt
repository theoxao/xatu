package com.theoxao.base.script.ast

import org.codehaus.groovy.GroovyBugError
import org.codehaus.groovy.ast.*
import org.codehaus.groovy.ast.ClassHelper.make
import org.codehaus.groovy.ast.expr.*
import org.codehaus.groovy.ast.stmt.*
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.syntax.Token
import org.codehaus.groovy.syntax.Types
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import org.springframework.transaction.support.DefaultTransactionDefinition
import java.util.*


/**
 * @author theo
 * @date 2019/6/26
 */
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
open class TransactionASTTransform : ASTTransformation, ClassCodeExpressionTransformer() {

    private var sourceUnit: SourceUnit? = null

    companion object {
        const val TRANSACTION_METHOD_SUFFIX = "\$transaction"
        const val TRANSACTION_MANGER_NAME = "tm"
        const val TRANSACTION_STATUS_NAME = "ts"
    }

    override fun visit(nodes: Array<out ASTNode>, source: SourceUnit) {
        sourceUnit = source
        if (nodes.size != 2 || nodes[0] !is AnnotationNode || nodes[1] !is AnnotatedNode) {
            throw GroovyBugError("Internal error: expecting [AnnotationNode, AnnotatedNode] but got: " + listOf(*nodes))
        }
        val annotationNode = nodes[0] as AnnotationNode
        val parent = nodes[1]
        if (parent is MethodNode) {
            val dc = parent.declaringClass
            val renamedMethod = MethodNode(
                parent.name + TRANSACTION_METHOD_SUFFIX,
                parent.modifiers,
                parent.returnType,
                parent.parameters,
                parent.exceptions,
                parent.code
            )
            dc.addMethod(renamedMethod)
            val autowireNode =
                FieldNode(
                    "$TRANSACTION_MANGER_NAME${AutowiredASTTransform.AUTOWIRE_BEAN_SUFFIX}", 1,
                    make(PlatformTransactionManager::class.java), null, null
                )
//            dc.addField(autowireNode)
            dc.addProperty(PropertyNode(autowireNode, autowireNode.modifiers, null, null))
            val tmFieldNode =
                FieldNode(TRANSACTION_MANGER_NAME, 1, make(PlatformTransactionManager::class.java), null, null)
            dc.addField(tmFieldNode)
            val parameters = parent.parameters
            val wrapTransaction = wrapTransaction(parent)
            parent.code = wrapTransaction
        }
    }

    private fun wrapTransaction(originMethod: MethodNode): Statement? {
        val methodBody = BlockStatement()
        //add code TransactionStatus ts = tm.getTransaction(new DefaultTransactionDefinition())
        methodBody.addStatement(
            ExpressionStatement(
                DeclarationExpression(
                    VariableExpression(TRANSACTION_STATUS_NAME, make(TransactionStatus::class.java)),
                    Token(Types.EQUAL, "=", -1, -1),
                    MethodCallExpression(
                        VariableExpression(TRANSACTION_MANGER_NAME, make(PlatformTransactionManager::class.java)),
                        ConstantExpression("getTransaction"),
                        ArgumentListExpression(
                            arrayOf(
                                ConstructorCallExpression(
                                    make(DefaultTransactionDefinition::class.java),
                                    ArgumentListExpression.EMPTY_ARGUMENTS
                                )
                            )
                        )
                    )
                )
            )
        )
        val tryStatements = BlockStatement()
        //add code def result = this.#originMethod$Suffix()
        tryStatements.addStatement(
            ExpressionStatement(
                DeclarationExpression(
                    VariableExpression("result", make(Any::class.java)),
                    Token(Types.EQUAL, "=", -1, -1),
                    MethodCallExpression(
                        VariableExpression("this", make(Any::class.java)),
                        ConstantExpression(originMethod.name + TRANSACTION_METHOD_SUFFIX),
                        ArgumentListExpression(originMethod.parameters)
                    )
                )
            )
        )
        //add code tm.commit(ts)
        tryStatements.addStatement(
            ExpressionStatement(
                MethodCallExpression(
                    VariableExpression(TRANSACTION_MANGER_NAME, make(PlatformTransactionManager::class.java)),
                    ConstantExpression("commit"),
                    ArgumentListExpression(
                        arrayOf(
                            VariableExpression(
                                TRANSACTION_STATUS_NAME,
                                make(TransactionStatus::class.java)
                            )
                        )
                    )
                )
            )
        )
        //add code  return result
        tryStatements.addStatement(
            ReturnStatement(
                VariableExpression("result", make(Any::class.java))
            )
        )
        val tryCatchStatement = TryCatchStatement(
            tryStatements, EmptyStatement()
        )
        val catchBlock = BlockStatement()

        //add code tm.rollback(ts)
        catchBlock.addStatement(
            ExpressionStatement(
                MethodCallExpression(
                    VariableExpression(TRANSACTION_MANGER_NAME, make(PlatformTransactionManager::class.java)),
                    ConstantExpression("rollback"),
                    VariableExpression(TRANSACTION_STATUS_NAME, make(TransactionStatus::class.java))
                )
            )
        )
        //add code throw e
        catchBlock.addStatement(ThrowStatement(VariableExpression("e", make(Exception::class.java))))
        val catchStatement = CatchStatement(
            Parameter(make(Exception::class.java), "e"),
            catchBlock
        )
        tryCatchStatement.addCatch(catchStatement)
        methodBody.addStatement(tryCatchStatement)
        return methodBody
    }

    override fun getSourceUnit(): SourceUnit? {
        return sourceUnit
    }

}
