package com.nutchanok.nat.bankapplication.network.interceptor

import com.nutchanok.nat.bankapplication.manager.LanguageManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val original: Request = chain.request()
        val request: Request = original.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .addHeader("Accept-Language", LanguageManager.getLanguage())
            .method(original.method, original.body)
            .build()

        return chain.proceed(request)
    }
}