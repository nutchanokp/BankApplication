package com.nutchanok.nat.bankapplication.model

import com.google.gson.annotations.SerializedName

data class UIContentModel(

    @SerializedName("code")
    var code: String? = null,

    @SerializedName("updated_at")
    var updatedAt: String? = null,

    @SerializedName("created_at")
    var createdAt: String? = null,

    @SerializedName("language")
    var language: String? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("content")
    var content: String? = null
)
