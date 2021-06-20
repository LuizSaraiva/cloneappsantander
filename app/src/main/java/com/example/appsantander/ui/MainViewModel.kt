package com.example.appsantander.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appsantander.data.Conta
import com.example.appsantander.data.DataFake

class MainViewModel : ViewModel() {

    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData()

    fun getConta(): LiveData<Conta> {
        mutableLiveData.value = DataFake().getData()

        return mutableLiveData
    }

}