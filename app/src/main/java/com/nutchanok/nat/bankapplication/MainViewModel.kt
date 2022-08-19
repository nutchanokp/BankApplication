//package com.nutchanok.nat.bankapplication
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.launch
//
//class MainViewModel(
//    private val repository: LoginRepository,
//    private val repositoryShop: ShopRepository
//) : ViewModel() {
//
//    private val mLoginResult: MutableLiveData<ResultWrapper<BaseResponse<LoginResponse>>> =
//        MutableLiveData()
//    private val mUserResult: MutableLiveData<ResultWrapper<BaseResponse<UserModel>>> =
//        MutableLiveData()
//    private val mUpdateToken: MutableLiveData<ResultWrapper<BaseResponse<Any>>> = MutableLiveData()
//
//    private val mPrinterZoneResult: MutableLiveData<ResultWrapper<BaseResponse<List<PrinterZoneModel>>>> =
//        MutableLiveData()
//
//    fun login(
//        password: String? = null,
//        username: String? = null,
//        deviceId: String?,
//        branchCode: String?
//    ) {
//        mLoginResult.value = ResultWrapper.Loading
//        viewModelScope.launch {
//            val result: ResultWrapper<BaseResponse<LoginResponse>> =
//                repository.login(password, username, deviceId, branchCode)
//            if (result is ResultWrapper.Success) {
//                result.data.data?.token?.let {
//                    SlashMenuAccountManager.saveToken(it)
//                    updateToken(deviceId, SlashMenuAccountManager.getFCM())
//                }
//            }
//            mLoginResult.value = result
//        }
//    }
//
//    fun updateToken(deviceId: String?, token: String?) {
//        if (deviceId == null && token == null) return
//        mUpdateToken.value = ResultWrapper.Loading
//        viewModelScope.launch {
//            val result: ResultWrapper<BaseResponse<Any>> =
//                repository.updateTokenFCM(deviceId!!, token!!)
//            getZoneList()
//            mUpdateToken.value = result
//        }
//    }
//
//    fun getMe() {
//        mUserResult.value = ResultWrapper.Loading
//        viewModelScope.launch {
//            val result: ResultWrapper<BaseResponse<UserModel>> =
//                repository.getMe()
//            if (result is ResultWrapper.Success) {
//                result.data.data?.let {
//                    SlashMenuAccountManager.saveUser(it)
//                }
//            }
//            mUserResult.value = result
//        }
//    }
//
//    fun getZoneList() {
//        mPrinterZoneResult.value = ResultWrapper.Loading
//        viewModelScope.launch {
//            val result = repositoryShop.getZoneList()
//            if (result is ResultWrapper.Success) {
//                result.data.data?.let { list ->
//                    SlashMenuAccountManager.saveZoneList(list)
//                }
//            }
//            getMe()
//        }
//    }
//
//    fun loginResult(): MutableLiveData<ResultWrapper<BaseResponse<LoginResponse>>> {
//        return mLoginResult
//    }
//
//    fun userResult(): MutableLiveData<ResultWrapper<BaseResponse<UserModel>>> = mUserResult
//
//    fun printerZoneResult() = mPrinterZoneResult
//
//}