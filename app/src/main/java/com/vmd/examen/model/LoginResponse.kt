package com.vmd.examen.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("id")
    val id: Long?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("username")
    val userName: String?,
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("default_profile_pic")
    val defaultProfilePic: Boolean?,
    @SerializedName("email")
    val email: String?,
)
