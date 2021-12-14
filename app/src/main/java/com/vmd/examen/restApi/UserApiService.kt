package com.vmd.examen.restApi

import com.vmd.examen.model.LoginResponse
import com.vmd.examen.model.PhotoResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApiService {
    @POST("users/signin.json")
    suspend fun logIn(@Body requestBody: LoginRequestBody): LoginResponse

    @GET("stage/photos/freetoedit/search.json")
    suspend fun getPhotos(): PhotoResponse
}