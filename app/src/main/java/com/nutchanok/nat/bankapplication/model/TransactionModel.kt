package com.nutchanok.nat.bankapplication.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.nutchanok.nat.bankapplication.enums.TransactionTypeEnum

data class TransactionModel(

    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("transfer_type")
    var transferType: String? = null,
    @SerializedName("amount")
    var amount: Double? = null,
    @SerializedName("date_time")
    var dateTime: String? = null,
    @SerializedName("from_account_bank")
    var fromAccountBank: String? = null,
    @SerializedName("from_account_no")
    var fromAccountNo: String? = null,
    @SerializedName("from_account_name")
    var fromAccountName: String? = null,

    @Transient
    var isExpanded: Boolean? = false

) : Parcelable {

    var transferTypeEnum: TransactionTypeEnum = TransactionTypeEnum.IN
        get() = TransactionTypeEnum.fromType(transferType ?: "IN")


    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(transferType)
        parcel.writeValue(amount)
        parcel.writeString(dateTime)
        parcel.writeString(fromAccountBank)
        parcel.writeString(fromAccountNo)
        parcel.writeString(fromAccountName)
        parcel.writeValue(isExpanded)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TransactionModel> {
        override fun createFromParcel(parcel: Parcel): TransactionModel {
            return TransactionModel(parcel)
        }

        override fun newArray(size: Int): Array<TransactionModel?> {
            return arrayOfNulls(size)
        }
    }

}
