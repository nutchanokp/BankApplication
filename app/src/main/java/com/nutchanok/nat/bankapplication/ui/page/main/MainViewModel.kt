package com.nutchanok.nat.bankapplication.ui.page.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nutchanok.nat.bankapplication.model.BankAccountModel
import com.nutchanok.nat.bankapplication.model.TransactionModel
import com.nutchanok.nat.bankapplication.model.UIContentModel
import com.nutchanok.nat.bankapplication.repository.AppRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: AppRepository
) : ViewModel() {

    private val mUIContentsResult: MutableLiveData<List<UIContentModel>> =
        MutableLiveData()
    private val mBankAccountsResult: MutableLiveData<List<BankAccountModel>> =
        MutableLiveData()
    private val mTransactionsResult: MutableLiveData<List<TransactionModel>> =
        MutableLiveData()

    fun getUIText() {
//        mUIContentsResult.value = ResultWrapper.Loading
        viewModelScope.launch {
            val result: MutableList<UIContentModel> = repository.getUIContents().toMutableList()
            mUIContentsResult.value = result
        }
    }

    fun getAccounts() {
//        mUIContentsResult.value = ResultWrapper.Loading
        viewModelScope.launch {
            val result: MutableList<BankAccountModel> = repository.getAccounts().toMutableList()
            mBankAccountsResult.value = result
        }
    }

    fun getTransactions() {
//        mUIContentsResult.value = ResultWrapper.Loading
        viewModelScope.launch {
            val result: MutableList<TransactionModel> = repository.getTransactions().toMutableList()
            mTransactionsResult.value = result
        }
    }

    fun uiContentsResult(): MutableLiveData<List<UIContentModel>> {
        return mUIContentsResult
    }

    fun accountsResult(): MutableLiveData<List<BankAccountModel>> {
        return mBankAccountsResult
    }

    fun transactionsResult(): MutableLiveData<List<TransactionModel>> {
        return mTransactionsResult
    }

}