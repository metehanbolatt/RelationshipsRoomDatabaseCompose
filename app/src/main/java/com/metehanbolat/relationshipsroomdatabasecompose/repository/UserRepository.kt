package com.metehanbolat.relationshipsroomdatabasecompose.repository

import androidx.lifecycle.LiveData
import com.metehanbolat.relationshipsroomdatabasecompose.dao.UserDao
import com.metehanbolat.relationshipsroomdatabasecompose.entity.Library
import com.metehanbolat.relationshipsroomdatabasecompose.entity.User
import com.metehanbolat.relationshipsroomdatabasecompose.entity.UserAndLibrary
import com.metehanbolat.relationshipsroomdatabasecompose.entity.UserAndLibraryOtM

class UserRepository(private val userDao: UserDao) {

    var readAllData: LiveData<List<UserAndLibrary>>? = null

    suspend fun addUser(item: List<User>) {
        userDao.insertUser(item = item)
    }

    suspend fun addLibrary(item: List<Library>) {
        userDao.insertLibrary(item = item)
    }

    fun getUserData(userId: Int): List<UserAndLibrary> = userDao.getUserAndLibrariesOtO(userId = userId)

    fun getUserDataOtM(userId: Int): List<UserAndLibraryOtM> = userDao.getUserAndLibrariesOtM(userId = userId)

}