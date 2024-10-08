package com.zoomcar.zcnetwork.error

import android.os.Parcelable
import com.zoomcar.zcnetwork.models.BaseErrorVO
import com.zoomcar.zcnetwork.utils.ErrorCode.CUSTOM_SERVER_ERROR
import com.zoomcar.zcnetwork.utils.ErrorCode.SERVER_ERROR
import com.zoomcar.zcnetwork.utils.ErrorString
import kotlinx.serialization.Serializable

/*
 * @created 05/01/2020 - 1:05 AM
 * @project ZC-Network-Client
 * @author Paras
 */
@Serializable
class NetworkError constructor(
    var httpCode: Int,
    var error: BaseErrorVO? = null
) {
    init {
        if (httpCode == SERVER_ERROR) {
            this.error?.errorCode = CUSTOM_SERVER_ERROR
        }
    }

    constructor(httpCode: Int, errorMsg: String) : this(httpCode) {
        error = BaseErrorVO()
        error!!.msg = errorMsg
    }

    constructor(httpCode: Int) : this(httpCode, null) {
        this.httpCode = httpCode
        this.error = BaseErrorVO()
        this.error!!.msg = ErrorString.SERVER_ERROR
    }
}