package com.example.mvvm.model

import com.example.mvvm.model.domain.User

class FakeDatabase {
    fun getCurrentUser():User{
        return User("Ahmed Nasser" , 1998)
    }
}