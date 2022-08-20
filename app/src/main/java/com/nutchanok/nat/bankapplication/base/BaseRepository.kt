package com.nutchanok.nat.bankapplication.base

import com.google.gson.Gson
import com.nutchanok.nat.bankapplication.base.response.BaseResponse
import com.nutchanok.nat.bankapplication.network.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

open class BaseRepository {

    private val defaultError = "Sorry, something went wrong"

    suspend fun <T : Any> safeApiCall(
        dispatcher: CoroutineDispatcher,
        call: (suspend () -> Response<T>)
    ): ResultWrapper<T> {
        return withContext(dispatcher) {
            try {
                val response = call.invoke()
                response.body()?.let {
//                    handleEventApp(response)
                } ?: run {
                    throw  HttpException(response)
                }
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> ResultWrapper.NetworkError
                    is HttpException -> {
                        throwable.response()?.let {
//                            handleEventApp(it)
                        } ?: run {
                            ResultWrapper.GenericError(0, defaultError)
                        }
                    }
                    else -> {
                        ResultWrapper.GenericError(0, defaultError)
                    }
                }
            }
        } as ResultWrapper<T>
    }

//    private fun <T : Any> handleEventApp(response: Response<T>): ResultWrapper<T> {
//        val code = response.code()
//        val messageModel: MessageModel = getApiError(response)
//        val errorResponse = messageModel.message
//        //header
//        val headers = response.headers()
//        // version|event
//        val versions = headers.get("FV-App-Version")?.split("|").orEmpty()
//        val version = versions.firstOrNull().toString()
//        var eventApp = if (versions.size >= 2) {
//            EventAppEnum.fromCode(versions[1])
//        } else {
//            EventAppEnum.NONE
//        }
//        if (eventApp == EventAppEnum.SOFT_UPDATE && SlashMenuAccountManager.isShowSoftUpdate) {
//            eventApp = EventAppEnum.NONE
//        }
//        return when {
//            eventApp == EventAppEnum.NONE && response.isSuccessful -> {
//                response.body()?.let {
//                    ResultWrapper.Success(it)
//                } ?: run {
//                    ResultWrapper.GenericError(0, defaultError)
//                }
//            }
//            code == ExceptionResponseCode.UNAUTHORIZED -> {
//                RxBus.publish(RxEvent.EventApp(EventAppEnum.UNAUTHORIZED, errorResponse))
//                ResultWrapper.EventApp(eventApp, errorResponse)
//            }
//            eventApp == EventAppEnum.MAINTENANCE -> {
//                RxBus.publish(RxEvent.EventApp(eventApp, errorResponse))
//                ResultWrapper.EventApp(eventApp, errorResponse)
//            }
//            eventApp == EventAppEnum.SOFT_UPDATE -> {
//                SlashMenuAccountManager.isShowSoftUpdate = true
//                RxBus.publish(RxEvent.EventApp(eventApp, version = version))
//                ResultWrapper.EventApp(eventApp, errorResponse)
//            }
//            eventApp == EventAppEnum.FORCE_UPDATE -> {
//                RxBus.publish(RxEvent.EventApp(eventApp, messageModel.message, version = version))
//                ResultWrapper.EventApp(eventApp, errorResponse)
//            }
//            else -> {
//                if (errorResponse.isNullOrEmpty()) {
//                    ResultWrapper.GenericError(code, defaultError)
//                } else {
//                    ResultWrapper.GenericError(code, errorResponse)
//                }
//            }
//        }
//    }
//
//    private fun getApiError(response: Response<*>?): MessageModel {
//        try {
//            if (response?.errorBody() != null) {
//                val json = response.errorBody()?.string()
//                return if (!json.isNullOrEmpty()) {
//                    val errorResponse = Gson().fromJson(json, BaseResponse::class.java)
//                    val message = errorResponse.systemResponse?.message.orEmpty()
//                    MessageModel(message, message)
//                } else {
//                    MessageModel()
//                }
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//        return MessageModel()
//    }
}