package com.theoxao.base.common.annotations;

import org.codehaus.groovy.transform.GroovyASTTransformationClass;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author theo
 * @date 2019/6/25
 */
@java.lang.annotation.Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.LOCAL_VARIABLE})
@GroovyASTTransformationClass("org.codehaus.groovy.transform.FieldASTTransformation")
public @interface Async {
}
