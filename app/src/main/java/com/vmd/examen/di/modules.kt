package com.vmd.examen.di

import com.vmd.examen.repository.UserRepository
import com.vmd.examen.repository.UserRepositoryImpl
import com.vmd.examen.restApi.UserApiService
import com.vmd.examen.retrofit.RetrofitClient
import com.vmd.examen.viewModel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

fun getUserRestService(retrofit: Retrofit) = retrofit.create(UserApiService::class.java)

val retrofitModule = module {
    single { getUserRestService(RetrofitClient.getRetrofit()) }
}

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { UserViewModel(get()) }
}