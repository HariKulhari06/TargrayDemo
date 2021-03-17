package com.hari.sample.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hari.sample.model.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {
    init {
        refreshUsers()
    }

    val usersFlow = userRepository.getUsersFlow()

     fun refreshUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.syncUsersData()
        }
    }
}