package com.metehanbolat.relationshipsroomdatabasecompose.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.metehanbolat.relationshipsroomdatabasecompose.database.UserDatabase
import com.metehanbolat.relationshipsroomdatabasecompose.entity.Library
import com.metehanbolat.relationshipsroomdatabasecompose.entity.User
import com.metehanbolat.relationshipsroomdatabasecompose.entity.UserAndLibrary
import com.metehanbolat.relationshipsroomdatabasecompose.entity.UserAndLibraryOtM
import com.metehanbolat.relationshipsroomdatabasecompose.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    private val _readAllData = MutableLiveData<List<UserAndLibraryOtM>>()
    val readAllData: LiveData<List<UserAndLibraryOtM>> = _readAllData

    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getInstance(application).userDao()
        repository = UserRepository(userDao = userDao)
    }

    /*
    fun getUserOtO(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _readAllData.postValue(repository.getUserData(userId = userId))
        }
    }

     */

    fun getUser(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _readAllData.postValue(repository.getUserDataOtM(userId = userId))
        }
    }

    fun addUser(item: List<User>) {
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(item)
        }
    }

    fun addLibrary(item: List<Library>) {
        viewModelScope.launch(Dispatchers.IO){
            repository.addLibrary(item)
        }
    }
}


