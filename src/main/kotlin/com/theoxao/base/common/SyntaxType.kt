package com.theoxao.base.common

import com.theoxao.antlr.PreParser
import com.theoxao.antlr.async.AsyncJavaPreParser


/**
 * create by theoxao on 2019/7/9
 */
enum class SyntaxType(var code: Int, var dsl: Boolean = false, var preParser: Class<out PreParser>? = null) {

    GROOVY(0),
    JAVA(1),
    ASYNC_JAVA(2, true, AsyncJavaPreParser::class.java),
    JS(3),
    DSL(4, true);


    companion object {
        fun getType(code: Int): SyntaxType {
            for (value in values()) {
                if (value.code == code) return value
            }
            return GROOVY
        }
    }

}

