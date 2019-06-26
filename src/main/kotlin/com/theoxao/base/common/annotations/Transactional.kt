package com.theoxao.base.common.annotations

import org.codehaus.groovy.transform.GroovyASTTransformationClass


/**
 * @author theo
 * @date 2019/6/26
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS, AnnotationTarget.TYPE)
@GroovyASTTransformationClass("com.theoxao.base.script.ast.TransactionASTTransform")
annotation class Transactional
