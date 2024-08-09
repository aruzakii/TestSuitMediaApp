package com.example.suitmediaapp.di

import com.example.core.domain.usecase.UserIteractor
import com.example.core.domain.usecase.UserUseCase
import com.example.suitmediaapp.thirdscreen.ThirdScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val useCaseModule = module {
    factory<UserUseCase> { UserIteractor(get()) }
}

val viewModelModule = module {
    viewModel { ThirdScreenViewModel( get()) }

}