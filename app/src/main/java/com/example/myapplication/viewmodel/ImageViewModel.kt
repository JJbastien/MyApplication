package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Repository
import com.example.myapplication.model.state.UIState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ImageViewModel(private val repository: Repository): ViewModel() {

    private val _data = MutableLiveData<UIState>()
    val data: LiveData<UIState>
    get() = _data
    // first load
    private val firstIndex = 0

    private val vieModelScope = CoroutineScope(Job())

    init {
        vieModelScope.launch {
            repository.getData(firstIndex).collect{
                _data.postValue(it)
            }
        }
    }

    // todo fetch next page
    // fun next(mnextIndex)

}