package com.nutchanok.nat.bankapplication.model.mock

import com.nutchanok.nat.bankapplication.common.enums.BankAccountTypeEnum
import com.nutchanok.nat.bankapplication.extensions.DateFormat
import com.nutchanok.nat.bankapplication.extensions.toDateFormat
import com.nutchanok.nat.bankapplication.model.BankAccountModel
import com.nutchanok.nat.bankapplication.model.TransactionModel
import com.nutchanok.nat.bankapplication.model.UIContentModel

object FakeModel {

    fun getUIContent(): MutableList<UIContentModel> {
        val contents: MutableList<UIContentModel> = mutableListOf()
        contents.add(UIContentModel())
        return contents
    }

    fun getAccounts(): MutableList<BankAccountModel> {
        val contents: MutableList<BankAccountModel> = mutableListOf()
        contents.add(
            BankAccountModel(
                userName = "Vayu",
                userLastname = "Metang",
                accountNo = "111-2-3353-9",
                currentBalance = 57000.00,
                availableBalance = 47599.00,
                accountType = BankAccountTypeEnum.SAVINGS.type
            )
        )
        contents.add(
            BankAccountModel(
                userName = "Vayu",
                userLastname = "Metang",
                accountNo = "099-2-3353-9",
                currentBalance = 999000.00,
                availableBalance = 99.00,
                accountType = BankAccountTypeEnum.SAVINGS.type
            )
        )
        contents.add(
            BankAccountModel(
                userName = "Vayu",
                userLastname = "Metang",
                accountNo = "123-2-3353-9",
                currentBalance = 5722000.00,
                availableBalance = 789599.00,
                accountType = BankAccountTypeEnum.FIXED.type
            )
        )
        contents.add(
            BankAccountModel(
                userName = "Vayu",
                userLastname = "Metang",
                accountNo = "432-2-3353-9",
                currentBalance = 1000000.00,
                availableBalance = 111599.00,
                accountType = BankAccountTypeEnum.CURRENT.type
            )
        )
        return contents
    }

    fun getTransactions(): MutableList<TransactionModel> {
        val contents: MutableList<TransactionModel> = mutableListOf()
        contents.add(
            TransactionModel(
                transferType = "OUT",
                amount = 1000.00,
                dateTime = "2022-08-10 22:20:22",
                fromAccountBank = "Krungthai",
                fromAccountName = "Vayu Metang",
                fromAccountNo = "333-3-7777-7"
            )
        )
        contents.add(
            TransactionModel(
                transferType = "PROMPTPAY",
                amount = 900.00,
                dateTime = "2022-08-10 22:20:22",
                fromAccountBank = "Krungthai2",
                fromAccountName = "Vayu Vayu",
                fromAccountNo = "777-2-7777-7"
            )
        )
        contents.add(
            TransactionModel(
                transferType = "IN",
                amount = 5000.00,
                dateTime = "2022-08-10 22:20:22",
                fromAccountBank = "Krungthai3",
                fromAccountName = "Vayu Vayu Vayu",
                fromAccountNo = "444-2-4444-4"
            )
        )
        contents.add(
            TransactionModel(
                transferType = "IN",
                amount = 555.00,
                dateTime = "2022-08-10 22:20:22",
                fromAccountBank = "Krungthai4",
                fromAccountName = "Vayu Vayu Vayu Vayu",
                fromAccountNo = "555-5-5555-9"
            )
        )
        return contents
    }

}