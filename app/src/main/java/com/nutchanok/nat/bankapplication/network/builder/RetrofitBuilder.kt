//package com.nutchanok.nat.bankapplication.network.builder
//
//import com.feyverly.slash.menu.pos.BuildConfig
//import com.feyverly.slash.menu.network.SlashMenuAPI
//import com.feyverly.slash.menu.network.SlashMenuNewAPI
//import com.feyverly.slash.menu.network.interceptor.AuthorizationInterceptor
//import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
//import okhttp3.MediaType.Companion.toMediaTypeOrNull
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//
//class RetrofitBuilder {
//    companion object {
//
//        /*media type*/
////        val MEDIA_TYPE_UTF_8 = "application/json; charset=utf-8".toMediaTypeOrNull()
//        val MEDIA_TYPE_FILE = "multipart/form-result".toMediaTypeOrNull()
//
//        private const val mTimeOut: Long = 90L
//
//        fun api(): SlashMenuAPI {
//            val okHttpClient = OkHttpClient.Builder()
//            okHttpClient.connectTimeout(mTimeOut, TimeUnit.SECONDS)
//            okHttpClient.readTimeout(mTimeOut, TimeUnit.SECONDS)
//            okHttpClient.addInterceptor(AuthorizationInterceptor())
//            return Retrofit.Builder()
//                .baseUrl(BuildConfig.BASE_URL)
//                .client(okHttpClient.build())
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(CoroutineCallAdapterFactory())
//                .build().create(SlashMenuAPI::class.java)
//        }
//
//        fun apiNewPath(): SlashMenuNewAPI {
//            val okHttpClient = OkHttpClient.Builder()
//            okHttpClient.connectTimeout(mTimeOut, TimeUnit.SECONDS)
//            okHttpClient.readTimeout(mTimeOut, TimeUnit.SECONDS)
//            okHttpClient.addInterceptor(AuthorizationInterceptor())
//            return Retrofit.Builder()
//                .baseUrl(BuildConfig.BASE_URL_MENU)
//                .client(okHttpClient.build())
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(CoroutineCallAdapterFactory())
//                .build().create(SlashMenuNewAPI::class.java)
//        }
//    }
//}