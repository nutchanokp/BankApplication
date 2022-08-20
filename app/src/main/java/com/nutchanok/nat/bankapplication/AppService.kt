package com.nutchanok.nat.bankapplication

import com.nutchanok.nat.bankapplication.base.response.BaseResponse
import com.nutchanok.nat.bankapplication.model.UIContentModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AppService {

//    @GET("languages")
//    fun getUIText(@Query("type") type: String): Call<BaseResponse<MutableList<GraphUiText>>>

    @GET("languages")
    fun getUIText(@Query("type") type: String): Call<BaseResponse<MutableList<UIContentModel>>>

}