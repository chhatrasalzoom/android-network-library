package com.zoomcar.zcnetwork.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JavaServiceBaseVO(
    @SerialName("code")
    var code: String? = null,
    @SerialName("details")
    var details: JavaServiceErrorDetailVO? = null
) : BaseErrorVO()

@Serializable
data class JavaServiceErrorDetailVO(
    @SerialName("errorCode")
    var errorCode: Int = 0,
    @SerialName("message")
    var message: String? = null,
    @SerialName("title")
    var title: String? = null,
    @SerialName("charge")
    var charge: Int = 0,
    @SerialName("tripUUID")
    var tripUUID: String? = null,
    @SerialName("walletBalance")
    var walletBalance: Double = 0.0,
    @SerialName("confirmationKey")
    var confirmationKey: String? = null
)