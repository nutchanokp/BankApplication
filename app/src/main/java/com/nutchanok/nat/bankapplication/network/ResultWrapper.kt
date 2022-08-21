package com.nutchanok.nat.bankapplication.network

import com.nutchanok.nat.bankapplication.common.enums.EventAppEnum

sealed class ResultWrapper<out T: Any> {
    data class Success<T : Any>(val data: T): ResultWrapper<T>()
    data class GenericError(val code : Int?, val message: String?) : ResultWrapper<Nothing>()
    data class EventApp(val eventApp: EventAppEnum, val message: String?) : ResultWrapper<Nothing>()
    object NetworkError: ResultWrapper<Nothing>()
    object Loading: ResultWrapper<Nothing>()
}