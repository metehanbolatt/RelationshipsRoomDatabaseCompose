package com.metehanbolat.relationshipsroomdatabasecompose.dao

import androidx.room.*
import com.metehanbolat.relationshipsroomdatabasecompose.entity.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(item: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLibrary(item: List<Library>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserLibrary(item: List<UserLibraryCrossRef>)

    @Transaction
    @Query("SELECT * FROM User WHERE userId = :userId")
    fun getUserWithLibrary(userId: Int): List<UserWithLibrary>

    @Transaction
    @Query("SELECT * FROM User WHERE userId = :id")
    fun getLibraryWithUser(id: Int): List<LibraryWithUser>

    @Transaction
    @Query("SELECT * FROM User WHERE userId = :userId")
    fun getUserAndLibrariesOtO(userId: Int): List<UserAndLibrary>

    @Transaction
    @Query("SELECT * FROM User WHERE userId = :userId")
    fun getUserAndLibrariesOtM(userId: Int): List<UserAndLibraryOtM>
}