//package com.nutchanok.nat.bankapplication.network.interceptor
//
//import android.location.Location
//import com.feyverly.slash.menu.pos.BuildConfig
//import com.feyverly.slash.menu.common.constant.PaperKey
//import com.feyverly.slash.menu.common.manager.SlashMenuAccountManager
//import com.feyverly.slash.menu.common.manager.SlashMenuLanguageManager
//import okhttp3.Interceptor
//import okhttp3.Request
//import okhttp3.Response
//import okhttp3.ResponseBody
//import timber.log.Timber
//
//class AuthorizationInterceptor : Interceptor {
//
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val token: String? = SlashMenuAccountManager.getToken()
//        val location: Location? = null
//        val lat: Double = location?.latitude ?: 0.0
//        val lng: Double = location?.longitude ?: 0.0
//        val deviceType = BuildConfig.DEVICE_TYPE
//
//        val original: Request = chain.request()
//        val request: Request = original.newBuilder()
//            .addHeader("Content-Type", "application/json")
//            .addHeader(
//                "User-Agent", "${BuildConfig.APPLICATION_ID} $deviceType"
//            )
//            .addHeader("Accept", "application/json")
//            .addHeader("Authorization", "Bearer $token")
//            .addHeader("Accept-Language", SlashMenuLanguageManager.getLanguage())
//            .addHeader("FV-App-Version", BuildConfig.VERSION_NAME)
//            .addHeader("FV-Client", deviceType)
//            .addHeader("FV-Data", "$lat|$lng")
//            .addHeader("app_name", "slash-menu")
//            .method(original.method, original.body)
//            .build()
//
//
//        if (BuildConfig.DEBUG) {
//            val response = chain.proceed(request)
//            val url = request.url.toString()
//            val code = response.code
//            val bodyString = response.body?.string().orEmpty()
//            val contentType = response.body?.contentType()
//            Timber.d("API Token: $token")
//            Timber.d("API URL Request: $url")
//            Timber.d("API Response Code : $code")
//            Timber.d("API Response Json : \n $bodyString")
//            Timber.d("API Token ${PaperKey.AUTH_TOKEN} : $token")
//            return response.newBuilder()
//                .body(ResponseBody.create(contentType, bodyString)).build()
//        }
//        return chain.proceed(request)
//    }
//}