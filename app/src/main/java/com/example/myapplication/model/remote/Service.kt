package com.example.myapplication.model.remote

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("public/images/paginate")
    suspend fun getImageList(
        @Query("cursorIndex") page: Int = 0,
        @Query("limit") size: Int = 5
    ): Response<ImageResponse>

    companion object{
        fun initRetrofit():Service =
            Retrofit.Builder()
                .baseUrl("https://api-staging-ypidedhdqa-uc.a.run.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Service::class.java)
    }
}