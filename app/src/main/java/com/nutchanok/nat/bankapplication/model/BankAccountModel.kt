package com.nutchanok.nat.bankapplication.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.nutchanok.nat.bankapplication.common.enums.BankAccountTypeEnum

data class BankAccountModel(

    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("user_name")
    var userName: String? = null,
    @SerializedName("user_lastname")
    var userLastname: String? = null,
    @SerializedName("account_no")
    var accountNo: String? = null,
    @SerializedName("account_type")
    var accountType: String? = null,
    @SerializedName("current_balance")
    var currentBalance: Double? = null,
    @SerializedName("available_balance")
    var availableBalance: Double? = null

) : Parcelable {

    var accountTypeEnum: BankAccountTypeEnum = BankAccountTypeEnum.SAVINGS
        get() = BankAccountTypeEnum.fromType(accountType ?: "SAVINGS")

    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(userName)
        parcel.writeString(userLastname)
        parcel.writeString(accountNo)
        parcel.writeString(accountType)
        parcel.writeValue(currentBalance)
        parcel.writeValue(availableBalance)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BankAccountModel> {
        override fun createFromParcel(parcel: Parcel): BankAccountModel {
            return BankAccountModel(parcel)
        }

        override fun newArray(size: Int): Array<BankAccountModel?> {
            return arrayOfNulls(size)
        }
    }
}
