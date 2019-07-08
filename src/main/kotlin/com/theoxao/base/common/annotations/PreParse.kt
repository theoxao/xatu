package com.theoxao.base.common.annotations


/**
 * create by theoxao on 2019/7/9
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class PreParse(val type: String)