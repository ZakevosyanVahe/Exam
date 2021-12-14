package com.vmd.examen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vmd.examen.model.LoginResponse
import com.vmd.examen.model.PhotoResponse
import com.vmd.examen.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _loginStateFlow: MutableStateFlow<LoginResponse?> = MutableStateFlow(null)
    val loginStateFlow: Flow<LoginResponse?> get() = _loginStateFlow
    private val _pageStateFlow: MutableStateFlow<PhotoResponse?> = MutableStateFlow(null)
    val pageStateFlow: Flow<PhotoResponse?> get() = _pageStateFlow

    fun login(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loginStateFlow.value = userRepository.login(username, password)
        }
    }

    fun getImages() {
        viewModelScope.launch(Dispatchers.IO) {
            _pageStateFlow.value = userRepository.getPhotos()
        }
    }

    fun getUser(): LoginResponse? {
        return _loginStateFlow.value
    }
}
