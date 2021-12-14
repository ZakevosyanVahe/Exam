package com.vmd.examen.repository

import com.vmd.examen.model.LoginResponse
import com.vmd.examen.model.PhotoResponse
import com.vmd.examen.restApi.LoginRequestBody
import com.vmd.examen.restApi.UserApiService

class UserRepositoryImpl(private val service: UserApiService) : UserRepository {
    override suspend fun login(username: String, password: String): LoginResponse {
        return service.logIn(LoginRequestBody(username, password))
    }

    override suspend fun getPhotos(): PhotoResponse {
        return service.getPhotos()
    }
}