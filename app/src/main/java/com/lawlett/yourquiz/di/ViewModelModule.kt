package com.lawlett.yourquiz.di

import com.lawlett.yourquiz.viewmodels.GameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
    viewModel { GameViewModel(get())}
}