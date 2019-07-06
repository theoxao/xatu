package com.theoxao.base.script.js


/**
 * create by theoxao on 2019/7/7
 */
class JsScript {

    val imports: List<JsImport> = mutableListOf()

    var content: String = ""
}


data class JsImport(val src: String, val alias: String)