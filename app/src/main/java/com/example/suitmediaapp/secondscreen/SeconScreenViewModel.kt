package com.example.suitmediaapp.secondscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeconScreenViewModel(): ViewModel() {
    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    fun setName(newName: String){
        if (_name.value != newName) {
            _name.value = newName
        }
    }
}