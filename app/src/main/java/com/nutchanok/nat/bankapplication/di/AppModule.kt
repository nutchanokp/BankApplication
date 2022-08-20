package com.nutchanok.nat.bankapplication.di

import com.nutchanok.nat.bankapplication.ui.page.main.MainViewModel
import com.nutchanok.nat.bankapplication.network.builder.RetrofitBuilder
import com.nutchanok.nat.bankapplication.repository.AppRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var appModule = module {
    /*api*/
    factory { RetrofitBuilder.api() }
    /*repository*/
    factory { AppRepository(get()) }
    /*viewModel*/
    viewModel { MainViewModel(get()) }
}