package com.metehanbolat.relationshipsroomdatabasecompose.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class User(
    @PrimaryKey
    val userId: Int,
    val name: String,
    val age: Int
)

@Entity
data class Library(
    @PrimaryKey
    val id: Int,
    val title: String,
    val userOwnerId: Int
)

/** One to One Relationship */
data class UserAndLibrary(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userOwnerId"
    )
    val library: Library
)

/** One to Many Relationship */
data class UserAndLibraryOtM(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userOwnerId"
    )
    val library: List<Library>
)
