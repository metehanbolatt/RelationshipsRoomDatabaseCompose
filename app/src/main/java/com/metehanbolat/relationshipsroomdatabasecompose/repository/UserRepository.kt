package com.metehanbolat.relationshipsroomdatabasecompose.repository

import androidx.lifecycle.LiveData
import com.metehanbolat.relationshipsroomdatabasecompose.dao.UserDao
import com.metehanbolat.relationshipsroomdatabasecompose.entity.*

class UserRepository(private val userDao: UserDao) {

    var readAllData: LiveData<List<UserAndLibrary>>? = null

    suspend fun addUser(item: List<User>) {
        userDao.insertUser(item = item)
    }

    suspend fun addLibrary(item: List<Library>) {
        userDao.insertLibrary(item = item)
    }

    suspend fun addUserLibrary(item: List<UserLibraryCrossRef>) = userDao.insertUserLibrary(item = item)

    fun getUserWithLibrary(userId: Int): List<UserWithLibrary> = userDao.getUserWithLibrary(userId = userId)

    fun getLibraryWithUser(id: Int): List<LibraryWithUser> = userDao.getLibraryWithUser(id = id)

    fun getUserData(userId: Int): List<UserAndLibrary> = userDao.getUserAndLibrariesOtO(userId = userId)

    fun getUserDataOtM(userId: Int): List<UserAndLibraryOtM> = userDao.getUserAndLibrariesOtM(userId = userId)

}