package com.example.myapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.model.RepositoryImpl
import com.example.myapplication.model.remote.Service
import com.example.myapplication.viewmodel.ImageViewModel

object Injector {

    fun provideViewModelFactory(): ViewModelProvider.Factory{

        return  object : ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return ImageViewModel(
                        provideRepository()
                    ) as T
                }
            }
    }

    private fun provideRepository() = RepositoryImpl(
        provideService()
    )
    private fun provideService() = Service.initRetrofit()
}