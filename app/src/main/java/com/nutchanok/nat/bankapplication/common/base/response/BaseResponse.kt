package com.nutchanok.nat.bankapplication.common.base.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<T> (
    @SerializedName("system_response")
    var systemResponse: SystemResponse? = null,
    @SerializedName("data")
    var data: T? = null
)