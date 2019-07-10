package com.theoxao.base.script.js


/**
 * create by theoxao on 2019/7/7
 */
class JsScript(var content: String = "") {

    val imports: List<JsImport> = mutableListOf()

    val resultName: String = "result"
}


data class JsImport(val src: String, val alias: String)
