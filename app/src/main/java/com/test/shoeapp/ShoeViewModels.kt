package com.test.shoeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.logging.Filter

class ShoeViewModels : ViewModel()  {

    var list = arrayListOf<Shoes>()

    val shoeDataing = MutableLiveData<Shoes>()

    init {
        shoeDataing.value = Shoes("a","2","aq","ss")
    }
}