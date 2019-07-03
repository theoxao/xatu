package com.theoxao.base.script.ast

import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.ClassHelper.make
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import org.springframework.transaction.support.DefaultTransactionDefinition

object JavaNodes {
    val stringNode = make(String::class.java)!!
    val metaApiNode = make(MetaApi::class.java)!!
    val listNode = make(List::class.java)!!
    val tmNode = make(PlatformTransactionManager::class.java)!!
    val tsNode = make(TransactionStatus::class.java)!!
    val transactionDefinitionNode = make(DefaultTransactionDefinition::class.java)!!
    val anyNode = make(Any::class.java)!!
    val exceptionNode = make(Exception::class.java)!!
}
