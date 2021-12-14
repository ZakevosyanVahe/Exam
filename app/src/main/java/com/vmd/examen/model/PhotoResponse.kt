package com.vmd.examen.model

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("response")
    val response: List<Image>
)
