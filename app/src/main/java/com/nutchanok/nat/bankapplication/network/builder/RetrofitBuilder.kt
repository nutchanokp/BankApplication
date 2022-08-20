package com.nutchanok.nat.bankapplication.network.builder

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.nutchanok.nat.bankapplication.network.AppAPI
import com.nutchanok.nat.bankapplication.network.interceptor.AuthorizationInterceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder {
    companion object {

        /*media type*/
//        val MEDIA_TYPE_UTF_8 = "application/json; charset=utf-8".toMediaTypeOrNull()
        val MEDIA_TYPE_FILE = "multipart/form-result".toMediaTypeOrNull()

        private const val mTimeOut: Long = 90L

        fun api(): AppAPI {
            val okHttpClient = OkHttpClient.Builder()
            okHttpClient.connectTimeout(mTimeOut, TimeUnit.SECONDS)
            okHttpClient.readTimeout(mTimeOut, TimeUnit.SECONDS)
            okHttpClient.addInterceptor(AuthorizationInterceptor())
            return Retrofit.Builder()
                .baseUrl("https://www.google.com")
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(AppAPI::class.java)
        }

    }
}