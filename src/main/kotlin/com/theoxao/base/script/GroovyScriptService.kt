package com.theoxao.base.script

import com.theoxao.base.common.GroovyShellHolder
import com.theoxao.base.persist.repository.ScriptRepository
import groovy.lang.Script
import org.springframework.stereotype.Service

/**
 * create by theoxao on 2019/5/19
 */
@Service
class GroovyScriptService(private val scriptRepository: ScriptRepository) {
    private val shell = GroovyShellHolder.shell

    fun parse(scriptAsString: String, invoke: Script.() -> Any): Any {
        return invoke(parse(scriptAsString))
    }

    fun parse(scriptAsString: String): Script = shell.parse(scriptAsString)

    fun mapParameterScript(scriptAsString: String, methodName: String, param: Map<Any, Any>): Any {
        val script = shell.parse(scriptAsString)
        return script.invokeMethod(methodName, param)
    }

    fun preParse(rawScript: String): String = TODO()

    fun findScriptById(id: String) = scriptRepository.findById(id) ?: throw RuntimeException("script not found")
}
