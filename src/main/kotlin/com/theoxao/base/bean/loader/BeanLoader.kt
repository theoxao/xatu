package com.theoxao.base.bean.loader

import com.theoxao.base.bean.BeanInjector
import groovy.lang.Script
import org.springframework.context.ApplicationContext


/**
 * @author theo
 * @date 2019/6/24
 */
abstract class BeanLoader(private val beanInjector: BeanInjector) {
    fun inject() {
        beanInjector.inject(beanClass())
    }

    abstract fun beanClass(): Class<*>
}
