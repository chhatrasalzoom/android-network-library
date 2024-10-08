package com.zoomcar.zcnetwork.error

import com.zoomcar.zcnetwork.models.JavaServiceBaseVO
import com.zoomcar.zcnetwork.models.JavaServiceErrorDetailVO
import com.zoomcar.zcnetwork.utils.ErrorCode.CUSTOM_SERVER_ERROR
import com.zoomcar.zcnetwork.utils.ErrorCode.SERVER_ERROR
import com.zoomcar.zcnetwork.utils.ErrorString
import kotlinx.serialization.Serializable

/*
 * @created 05/01/2020 - 1:00 AM
 * @project ZC-Network-Client
 * @author Paras
 */
@Serializable
class JavaServiceNetworkError constructor(
    var error: JavaServiceBaseVO?,
    var httpCode: Int

) {

    init {
        if (httpCode == SERVER_ERROR) {
            error?.details?.errorCode = CUSTOM_SERVER_ERROR
        }
    }

    constructor(httpCode: Int) : this(null, httpCode) {
        this.httpCode = httpCode
        this.error = JavaServiceBaseVO()
        this.error?.code = httpCode.toString()
        if (this.error?.details == null) this.error?.details = JavaServiceErrorDetailVO()
        this.error?.details?.message = ErrorString.SERVER_ERROR
    }
}