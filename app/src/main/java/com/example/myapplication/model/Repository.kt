package com.example.myapplication.model

import com.example.myapplication.model.remote.ImageResponse
import com.example.myapplication.model.state.UIState
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getData(nextPage: Int): Flow<UIState>
}