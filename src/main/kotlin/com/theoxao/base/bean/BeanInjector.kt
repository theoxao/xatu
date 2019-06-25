package com.theoxao.base.bean

import org.springframework.beans.factory.support.BeanDefinitionBuilder
import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component


/**
 * @author theo
 * @date 2019/6/24
 */

@Component
class BeanInjector(private val applicationContext: ApplicationContext) {

    private val bf = applicationContext.autowireCapableBeanFactory as DefaultListableBeanFactory

    fun inject(name: String, clazz: Class<*>) {
        bf.registerBeanDefinition(name, BeanDefinitionBuilder.genericBeanDefinition(clazz).beanDefinition)
    }

    fun inject(clazz: Class<*>) {
        inject(clazz.name, clazz)
    }

    inline fun <reified T> inject(name: String) {
        inject(name, T::class.java)
    }

    inline fun <reified T> inject() {
        inject<T>(T::class.java.name)
    }

}
