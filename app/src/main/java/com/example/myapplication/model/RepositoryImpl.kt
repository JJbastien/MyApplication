package com.example.myapplication.model

import com.example.myapplication.model.remote.Service
import com.example.myapplication.model.state.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(private val service: Service): Repository {

    override fun getData(nextPage: Int): Flow<UIState> {
        return flow{
            emit(UIState.Loading)

            val response = service.getImageList(nextPage)

            if (response.isSuccessful) {
                response.body()?.let {
                    emit(UIState.Response(it))
                } ?: emit(UIState.Error("Error body"))
            }else {
                emit(UIState.Error(response.message()))
            }
        }
    }
}