package com.example.retorfit_api_libri

import com.google.gson.annotations.SerializedName

data class CategoryResponse(

    @SerializedName("codigo_categoria") var id:Int? = 0,
    @SerializedName("nome_categoria") var email:String? = ""
)
