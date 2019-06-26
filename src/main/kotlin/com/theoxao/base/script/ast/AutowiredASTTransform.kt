package com.theoxao.base.script.ast

import ch.qos.logback.classic.util.StatusViaSLF4JLoggerFactory.addError
import com.theoxao.base.common.annotations.Autowired
import org.codehaus.groovy.GroovyBugError
import org.codehaus.groovy.ast.*
import org.codehaus.groovy.ast.ClassHelper.make
import org.codehaus.groovy.ast.expr.DeclarationExpression
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformationClass
import java.util.*


/**
 * @author theo
 * @date 2019/6/26
 */
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class AutowiredASTTransform : ASTTransformation {

    companion object {
        const val AUTOWIRE_BEAN_SUFFIX = "\$autowire"
    }

    private val ASTTRANSFORMCLASS_TYPE = make(GroovyASTTransformationClass::class.java)

    override fun visit(nodes: Array<out ASTNode>, source: SourceUnit) {
        if (nodes.size != 2 || nodes[0] !is AnnotationNode || nodes[1] !is AnnotatedNode) {
            throw GroovyBugError("Internal error: expecting [AnnotationNode, AnnotatedNode] but got: " + Arrays.asList(*nodes))
        }
        val annotationNode = nodes[0]
        val de = nodes[1]
        if (de is DeclarationExpression) {
            val cNode = de.getDeclaringClass()
            if (de.isMultipleAssignmentDeclaration) {
                addError("Annotation @Autowired not supported with multiple assignment notation.", de)
                return
            }
            val ve = de.variableExpression
            val variableName = ve.name
            val fieldNode =
                FieldNode(variableName, ve.modifiers, ve.type, null, de.rightExpression)
            fieldNode.setSourcePosition(de)
            cNode.addProperty(PropertyNode(fieldNode, ve.modifiers, null, null))
            val autowireNode =
                FieldNode("$variableName$AUTOWIRE_BEAN_SUFFIX", ve.modifiers, ve.type, null, de.rightExpression)
            fieldNode.setSourcePosition(de)
            cNode.addProperty(PropertyNode(autowireNode, ve.modifiers, null, null))

            val annotations = de.annotations
            for (annotation in annotations) {
                val annotationClassNode = annotation.classNode
                if (notTransform(annotationClassNode) || acceptableTransform(annotation)) {
                    fieldNode.addAnnotation(annotation)
                }
            }
        }
    }

    private fun notTransform(annotationClassNode: ClassNode): Boolean {
        return annotationClassNode.getAnnotations(ASTTRANSFORMCLASS_TYPE).isEmpty()
    }


    private fun acceptableTransform(annotation: AnnotationNode): Boolean {
        // TODO also check for phase after sourceUnit.getPhase()? but will be ignored anyway?
        // TODO we should only copy those annotations with FIELD_TARGET but haven't visited annotations
        // and gathered target info at this phase, so we can't do this:
        // return annotation.isTargetAllowed(AnnotationNode.FIELD_TARGET);
        // instead just don't copy ourselves for now
        return annotation.classNode != make(Autowired::class.java)
    }
}
