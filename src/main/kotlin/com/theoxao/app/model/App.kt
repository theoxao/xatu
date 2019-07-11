package com.theoxao.app.model

import com.theoxao.app.model.dto.AppDTO
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

    var image: String? = null

    constructor(name: String, desc: String?, image: String?) {
        this.name = name
        this.desc = desc
        this.image = image
    }

    constructor()

    fun dto(): AppDTO {
        val dto = AppDTO()
        dto.id = id.toHexString()
        dto.name = this.name
        dto.desc = this.desc
        dto.image = this.image
        return dto
    }
}
