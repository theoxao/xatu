package com.theoxao.base.script.antlr


/**
 *
 * TODO does not support multi method or class wrapped method; need to be fixed
 * @author theo
 * @date 2019/6/20
 */
class ParamNameListener : AsyncriptBaseListener() {

    val paramNameList = mutableListOf<String>()

    override fun enterFormalParameterList(ctx: AsyncriptParser.FormalParameterListContext?) {
        ctx?.formalParameter()?.forEach {
            paramNameList.add(it.variableDeclaratorId().text)
        }
        ctx?.lastFormalParameter()?.variableDeclaratorId()?.text?.let { paramNameList.add(it) }
    }

}
