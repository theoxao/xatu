package com.theoxao.app.model.vo

import com.theoxao.base.common.SyntaxType
import com.theoxao.base.common.TriggerType


open class ScriptVO {
    var id: String? = null
    var content: String = ""
    var triggerType: String = TriggerType.HTTP.name
    var methodName: String = "service"
    var syntaxType = SyntaxType.GROOVY.name
    var app: String = ""
}