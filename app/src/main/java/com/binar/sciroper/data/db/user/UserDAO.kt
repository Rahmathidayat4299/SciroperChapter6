package com.binar.sciroper.data.db.user

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {

    @Insert
    suspend fun insertUser(user: User): Long

    @Delete
    suspend fun deleteUser(user: User): Int

    @Update
    suspend fun updateUser(user: User): Int

    @Query("SELECT * FROM ${User.TABLE_NAME} WHERE id = :id")
    fun getUserById(id: Int): LiveData<User>

    @Query("SELECT * FROM ${User.TABLE_NAME} WHERE email = :email AND password = :password")
    fun getUserByEmailAndPassword(email: String, password: String): LiveData<User>

    @Query("DELETE FROM ${User.TABLE_NAME}")
    suspend fun clearAllUser(): Int

    @Query("SELECT * FROM ${User.TABLE_NAME}")
    fun getUsers(): LiveData<List<User>>


    @Query("SELECT * FROM ${User.TABLE_NAME} WHERE id = :id")
    fun getUserByIdNoLiveData(id: Int): User
}