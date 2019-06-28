package com.theoxao.base.persist.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty


/**
 * @author theo
 * @date 2019/6/28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class GithubData {
    lateinit var name: String
    lateinit var path: String
    lateinit var relativePath: String
    lateinit var url: String
    @JsonProperty("download_url")
    var downloadUrl: String? = null
    lateinit var type: String
    var content: String? = null
    var child: List<GithubData> = mutableListOf()
}
