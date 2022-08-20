package com.nutchanok.nat.bankapplication.repository

import com.nutchanok.nat.bankapplication.base.BaseRepository
import com.nutchanok.nat.bankapplication.base.response.BaseResponse
import com.nutchanok.nat.bankapplication.model.BankAccountModel
import com.nutchanok.nat.bankapplication.model.TransactionModel
import com.nutchanok.nat.bankapplication.model.UIContentModel
import com.nutchanok.nat.bankapplication.model.mock.FakeModel
import com.nutchanok.nat.bankapplication.network.AppAPI
import com.nutchanok.nat.bankapplication.network.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class AppRepository(
    private val api: AppAPI,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : BaseRepository() {


//    suspend fun getUIContents(): ResultWrapper<BaseResponse<List<UIContentModel>>> {
//        return safeApiCall(dispatcher, call = { api.getUIContents() })
//    }

    suspend fun getUIContents(): List<UIContentModel> {
        return FakeModel.getUIContent()
    }

    suspend fun getAccounts(): List<BankAccountModel> {
        return FakeModel.getAccounts()
    }

    suspend fun getTransactions(): List<TransactionModel> {
        return FakeModel.getTransactions()
    }

}