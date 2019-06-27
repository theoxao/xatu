package com.theoxao.base.script.ast


/**
 * @author theo
 * @date 2019/6/27
 */
class MetaApi(val uri: String, val method: String, val requestMethod: String) {
    companion object {
        fun fromString(str: String): MetaApi {
            val list = str.split("\$")
            return MetaApi(list[0], list[1], list[2])
        }
    }

    override fun toString(): String {
        return "$uri\$$method\$$requestMethod"
    }

}
