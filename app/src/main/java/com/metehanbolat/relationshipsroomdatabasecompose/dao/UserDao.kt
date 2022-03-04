package com.metehanbolat.relationshipsroomdatabasecompose.dao

import androidx.room.*
import com.metehanbolat.relationshipsroomdatabasecompose.entity.Library
import com.metehanbolat.relationshipsroomdatabasecompose.entity.User
import com.metehanbolat.relationshipsroomdatabasecompose.entity.UserAndLibrary
import com.metehanbolat.relationshipsroomdatabasecompose.entity.UserAndLibraryOtM

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(item: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLibrary(item: List<Library>)

    @Transaction
    @Query("SELECT * FROM User WHERE userId = :userId")
    fun getUserAndLibrariesOtO(userId: Int): List<UserAndLibrary>

    @Transaction
    @Query("SELECT * FROM User WHERE userId = :userId")
    fun getUserAndLibrariesOtM(userId: Int): List<UserAndLibraryOtM>
}