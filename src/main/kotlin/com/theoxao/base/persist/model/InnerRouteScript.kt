package com.theoxao.base.persist.model

import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "inner_route")
class InnerRouteScript : RouteScript() {

}
