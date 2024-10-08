package com.zoomcar.networkclient

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.readystatesoftware.chuck.ChuckInterceptor
import com.zoomcar.networkclient.databinding.ActivityMainBinding
import com.zoomcar.zcnetwork.core.ZcNetworkBuilder
import com.zoomcar.zcnetwork.core.ZcNetworkListener
import com.zoomcar.zcnetwork.error.NetworkError
import com.zoomcar.zcnetwork.utils.LibTag
import com.zoomcar.zcnetwork.utils.ZcRequestType
import com.zoomcar.zcnetwork.utils.deserializeJSON
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.button.setOnClickListener {
            val zcNetworkBuilder: ZcNetworkBuilder = ZcNetworkBuilder()
                .setActivity(this)
                .setBodyParams(hashMapOf("title" to "foo", "body" to "bar", "userId" to 1))
                .setRequestType(ZcRequestType.GET)
                .setHeaderParams(hashMapOf("Accept" to "application/json", "key" to "value"))
                .setUrl("https://jsonplaceholder.typicode.com/users/1")
                .setListener(object : ZcNetworkListener {
                    override fun onSuccess(
                        response: JsonElement?,
                        requestCode: Int
                    ) {
                        val user =
                            response?.let { deserializeJSON.decodeFromJsonElement<User>(response) }
                        binding.textView.text = "${response?.toString()} \n\n $user"
                        Log.d(LibTag.TAG, "onSuccess: ${user}")
                    }

                    override fun onError(error: NetworkError) {
                        Log.d(LibTag.TAG, "onError: ${error.httpCode}")
                    }
                })
            zcNetworkBuilder.request()
        }
    }
}