package com.example.gifswithmvvm

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gifModel = module {
    single { RetrofitBuilder }
    single<Repository> { RepositoryImpl(get()) }
    viewModel { ViewModel(get()) }
}