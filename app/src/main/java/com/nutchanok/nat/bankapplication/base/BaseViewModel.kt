//package com.nutchanok.nat.bankapplication.base
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.feyverly.pos.common.SingleLiveEvent
//import com.feyverly.pos.service.FeyverlyMessage
//
//open class BaseViewModel : ViewModel() {
//
//    val loading = MutableLiveData<Boolean>()
//    val errorMessage = SingleLiveEvent<FeyverlyMessage>()
//    val error = MutableLiveData<String>()
//
//    fun showLoading() {
//        loading.value = true
//    }
//
//    fun hideLoading() {
//        loading.value = false
//    }
//
//    fun showErrorMessage(message: FeyverlyMessage?) {
//        if (message != null) {
//            errorMessage.value = message
//        }
//    }
//
//    fun showErrorMessage(message: String?) {
//        if (message != null) {
//            error.value = message
//        }
//    }
//
//}