package com.theoxao.base.common


/**
 * @author theo
 * @date 2019/6/25
 */
enum class ScriptType {
    /**
     * data object, entity etc.;
     */
    DATA,
    /**
     * spring bean definitions;
     */
    BEAN,
    /**
     * script triggered by http;
     */
    ROUTE,
    /**
     * script triggered by scheduler
     */
    SCHEDULER,
    /**
     * common function or pure function
     */
    FUNCTION

}
