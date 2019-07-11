package com.theoxao.app.model

import com.theoxao.base.persist.model.Trigger
import org.springframework.data.mongodb.core.mapping.Document


@Document("trigger")
class RouteTrigger : Trigger() {

    var uri: String = ""
    var requestMethod: String = "GET"

}