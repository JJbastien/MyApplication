package com.example.myapplication.model.state

import com.example.myapplication.model.remote.ImageResponse

sealed class UIState{
    data class Response(val data: ImageResponse): UIState()
    data class Error(val errorMessage: String): UIState()
    object Loading: UIState()
}
