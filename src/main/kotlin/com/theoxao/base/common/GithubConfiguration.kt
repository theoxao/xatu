package com.theoxao.base.common

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component


/**
 * @author theo
 * @date 2019/6/28
 */
@Configuration
@Component
@ConfigurationProperties(prefix = "iotaki.script.route")
open class GithubConfiguration {
    var git = ""
    var branch = "master"
    var path = ""
    var packageAsRoute = false
}
