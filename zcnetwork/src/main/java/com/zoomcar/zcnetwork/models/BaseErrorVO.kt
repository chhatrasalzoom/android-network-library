package com.zoomcar.zcnetwork.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
open class BaseErrorVO {
    @SerialName(value = "status")
    var status: Int = 0

    @SerialName(value = "error_code")
    var errorCode: Int = 0

    @SerialName(value = "error_title")
    var errorTitle: String? = null

    @SerialName("msg")
    var msg: String? = null

    @SerialName("httpStatusCode")
    var httpStatusCode: Int = 0

    @SerialName("metadata")
    var metadata: JsonElement? = null
}