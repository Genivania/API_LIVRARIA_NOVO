package com.example.retorfit_api_libri

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("/categoria/listarCategoria/{codigo_categoria}")
    suspend fun getCategoryByID(@Path("codigo_categoria") codigo_categoria:String): Response<BaseResponse<CategoryResponse>>

    @POST("/categoria/cadastrarCategoria")
    suspend fun createCategory(@Body body: JsonObject): Response<JsonObject>
}