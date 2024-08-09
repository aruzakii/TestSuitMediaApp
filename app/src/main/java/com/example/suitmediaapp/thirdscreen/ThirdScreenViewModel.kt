package com.example.suitmediaapp.thirdscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.UserUseCase

class ThirdScreenViewModel(userUseCase: UserUseCase): ViewModel() {
    val users =  userUseCase.getAllUser().asLiveData()
}