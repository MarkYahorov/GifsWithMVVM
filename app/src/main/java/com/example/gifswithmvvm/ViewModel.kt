package com.example.gifswithmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gifswithmvvm.domain.model.Original
import com.example.gifswithmvvm.domain.model.ThisData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(private val repository: Repository) : ViewModel() {

    private val mGif = MutableLiveData<List<Original>>()
    val gifts: LiveData<List<Original>> = mGif

    fun getAllViewModelGifts(gif: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val giftss = repository.getGifts(gif = gif)
            mGif.postValue(giftss)
        }
    }

}