package com.example.pythonapp.repositories

import androidx.lifecycle.LiveData
import com.example.pythonapp.database.roomdb_user.User
import com.example.pythonapp.database.roomdb_user.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(private val userDao: UserDao) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val userList: LiveData<List<User>> = userDao.getUsers()

    fun addUSer(user: User){
        coroutineScope.launch(Dispatchers.IO){
            userDao.addUser(user)
        }
    }

    fun editUser(id: Int, name: String){
        coroutineScope.launch(Dispatchers.IO){
            userDao.update(id, name)
        }
    }

    fun deleteUser(userId: Int){
        coroutineScope.launch(Dispatchers.IO){
            userDao.deleteUser(userId)
        }
    }
}