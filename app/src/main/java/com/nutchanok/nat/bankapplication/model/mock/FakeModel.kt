package com.nutchanok.nat.bankapplication.model.mock

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
                accountType = "saving"
            )
        )
        contents.add(
            BankAccountModel(
                userName = "Vayu",
                userLastname = "Metang",
                accountNo = "099-2-3353-9",
                currentBalance = 999000.00,
                availableBalance = 99.00,
                accountType = "saving"
            )
        )
        contents.add(
            BankAccountModel(
                userName = "Vayu",
                userLastname = "Metang",
                accountNo = "123-2-3353-9",
                currentBalance = 5722000.00,
                availableBalance = 789599.00,
                accountType = "saving"
            )
        )
        contents.add(
            BankAccountModel(
                userName = "Vayu",
                userLastname = "Metang",
                accountNo = "432-2-3353-9",
                currentBalance = 1000000.00,
                availableBalance = 111599.00,
                accountType = "saving"
            )
        )
        return contents
    }

    fun getTransactions(): MutableList<TransactionModel> {
        val contents: MutableList<TransactionModel> = mutableListOf()
        contents.add(
            TransactionModel(
                transfer_type = "asdf",
                amount = 1000.00,
                date_time = "",
                from_account_bank = "asdf",
                from_account_name = "asdf",
                from_account_no = "asdf"
            )
        )
        contents.add(
            TransactionModel(
                transfer_type = "asdf",
                amount = 1000.00,
                date_time = "",
                from_account_bank = "asdf",
                from_account_name = "asdf",
                from_account_no = "asdf"
            )
        )
        contents.add(
            TransactionModel(
                transfer_type = "asdf",
                amount = 1000.00,
                date_time = "",
                from_account_bank = "asdf",
                from_account_name = "asdf",
                from_account_no = "asdf"
            )
        )
        contents.add(
            TransactionModel(
                transfer_type = "asdf",
                amount = 1000.00,
                date_time = "",
                from_account_bank = "asdf",
                from_account_name = "asdf",
                from_account_no = "asdf"
            )
        )
        return contents
    }

}