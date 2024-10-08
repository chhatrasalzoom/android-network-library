package com.zoomcar.zcnetwork.core

import com.zoomcar.zcnetwork.error.NetworkError
import com.zoomcar.zcnetwork.models.BaseErrorVO
import com.zoomcar.zcnetwork.utils.deserializeJSON
import kotlinx.serialization.json.JsonElement

/*
  * @created 07/01/2020 - 12:09 PM
  * @project ZC-Network-Client
  * @author Paras
*/
interface ZcNetworkListener {
    fun onSuccess(response: JsonElement?, requestCode: Int)
    fun onError(error: NetworkError)

    fun buildNetworkError(httpCode: Int, data: ByteArray): NetworkError {
        val baseErrorVO: BaseErrorVO
        return try {
            baseErrorVO = deserializeJSON.decodeFromString<BaseErrorVO>(String(data))
            NetworkError(httpCode, baseErrorVO)
        } catch (e: Exception) {
            e.printStackTrace()
            NetworkError(0)
        }
    }
}