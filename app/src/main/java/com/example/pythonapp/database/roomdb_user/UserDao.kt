package com.example.pythonapp.database.roomdb_user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun addUser(user: User)

    @Query("SELECT * FROM User")
    fun getUsers(): LiveData<List<User>>

    @Query("UPDATE user SET name = :name WHERE id = :id")
    fun update(id: Int, name: String)


    @Query("DELETE FROM user WHERE id = :id")
    fun deleteUser(id: Int)
}