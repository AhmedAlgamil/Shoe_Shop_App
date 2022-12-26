package com.test.shoeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class test<T>: ViewModel() {

    var data: MutableLiveData<ArrayList<T>> = MutableLiveData()

    fun setData(anyData:ArrayList<T>){
        data.value = anyData
    }

    val getAnyData: LiveData<ArrayList<T>>
        get() = data

}