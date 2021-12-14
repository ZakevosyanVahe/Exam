package com.vmd.examen.repository

import com.vmd.examen.model.LoginResponse
import com.vmd.examen.model.PhotoResponse

interface UserRepository {

    suspend fun login(username:String, password: String): LoginResponse
    suspend fun getPhotos(): PhotoResponse
}