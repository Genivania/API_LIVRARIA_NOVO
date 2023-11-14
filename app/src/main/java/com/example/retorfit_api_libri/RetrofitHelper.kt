package com.example.retorfit_api_libri

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val baseurl = "http://10.107.138.175:3000"
    fun getInstance(): Retrofit{
        return Retrofit.Builder().baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}