package com.theoxao.test

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import java.util.concurrent.CompletableFuture


/**
 * @author theo
 * @date 2019/6/25
 */
@Document(collection = "app")
class App {
    var id = ObjectId()

    var name = ""

    var desc: String? = null

    constructor(name: String, desc: String?) {
        this.name = name
        this.desc = desc
    }

    constructor()

    override fun toString(): String {
        return this.id.toHexString() + this.name + this.desc
    }

    fun future(): CompletableFuture<String> {
        return CompletableFuture.completedFuture("this is a message from future")
    }
}
