package com.example.retorfit_api_libri

import com.google.gson.annotations.SerializedName

data class BaseResponse<T> (
    @SerializedName("data")
    var data: T? = null
)