package com.theoxao.base.common.annotations

import org.codehaus.groovy.transform.GroovyASTTransformationClass


/**
 * @author theo
 * @date 2019/6/26
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.FIELD)
@GroovyASTTransformationClass("com.theoxao.base.script.ast.AutowiredASTTransform")
annotation class Autowired
