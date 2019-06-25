package com.theoxao.base.persist.repository

import com.theoxao.base.persist.model.ScriptModel


/**
 * @author theo
 * @date 2019/6/19
 */
interface ScriptRepository {

    fun findById(id: String): ScriptModel?

}
