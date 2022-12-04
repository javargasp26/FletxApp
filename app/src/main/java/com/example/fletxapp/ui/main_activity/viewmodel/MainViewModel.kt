package com.example.fletxapp.ui.main_activity.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fletxapp.domain.GetResponseUseCase
import com.example.fletxapp.domain.Model
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val responseModel = MutableLiveData<List<Model>?>()
    val isLoading = MutableLiveData<Boolean>()
    var getResponseUseCase = GetResponseUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)

            val result = getResponseUseCase()
            if(!result.isNullOrEmpty()){
                responseModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}