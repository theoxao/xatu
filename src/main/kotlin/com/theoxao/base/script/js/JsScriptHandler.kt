package com.theoxao.base.script.js

import org.graalvm.polyglot.Context


/**
 * create by theoxao on 2019/7/7
 */

class JsScriptHandler {
    private val jsContext: Context = Context.create("js")


    fun function(js: JsScript): Any? {
        return jsContext.eval("js", js.content)
    }
}