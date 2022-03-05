package com.metehanbolat.relationshipsroomdatabasecompose.entity

import androidx.room.*

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

@Entity(primaryKeys = ["userId", "id"])
data class UserLibraryCrossRef(
    val userId: Int,
    val id: Int
)

/** Many to Many Relationship */
data class UserWithLibrary(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "id",
        associateBy = Junction(UserLibraryCrossRef::class)
    )
    val library: List<Library>
)

data class LibraryWithUser(
    @Embedded val library: Library,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId",
        associateBy = Junction(UserLibraryCrossRef::class)
    )
    val user: List<User>
)


