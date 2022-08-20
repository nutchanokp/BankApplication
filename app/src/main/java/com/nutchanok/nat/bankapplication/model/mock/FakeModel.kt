package com.nutchanok.nat.bankapplication.model.mock

import com.nutchanok.nat.bankapplication.model.BankAccountModel
import com.nutchanok.nat.bankapplication.model.TransactionModel
import com.nutchanok.nat.bankapplication.model.UIContentModel

object FakeModel {

    fun getUIContent():MutableList<UIContentModel>{
        val contents :MutableList<UIContentModel> = mutableListOf()
        contents.add(UIContentModel())
        contents.add(UIContentModel())
        contents.add(UIContentModel())
        contents.add(UIContentModel())
        return contents
    }

    fun getAccounts():MutableList<BankAccountModel>{
        val contents :MutableList<BankAccountModel> = mutableListOf()
        contents.add(BankAccountModel())
        contents.add(BankAccountModel())
        contents.add(BankAccountModel())
        contents.add(BankAccountModel())
        return contents
    }

    fun getTransactions():MutableList<TransactionModel>{
        val contents :MutableList<TransactionModel> = mutableListOf()
        contents.add(TransactionModel())
        contents.add(TransactionModel())
        contents.add(TransactionModel())
        contents.add(TransactionModel())
        return contents
    }

}