package com.nutchanok.nat.bankapplication.model

import com.google.gson.annotations.SerializedName

data class TransactionModel(

    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("transfer_type")
    var transfer_type: String? = null,
    @SerializedName("amount")
    var amount: Double? = null,
    @SerializedName("date_time")
    var date_time: String? = null,
    @SerializedName("from_account_bank")
    var from_account_bank: String? = null,
    @SerializedName("from_account_no")
    var from_account_no: String? = null,
    @SerializedName("from_account_name")
    var from_account_name: String? = null

)
