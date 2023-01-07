package com.example.mvvm.model.repository

import com.example.mvvm.model.FakeApiService
import com.example.mvvm.model.FakeDatabase

class Repository {

    private val api = FakeApiService()
    private val database = FakeDatabase()

    fun getCurrentUser() = database.getCurrentUser()
    fun getRandomWisdom() = api.getRandomWisdom()

    fun getRxRandomWisdom() = api.getRxRandomWisdom()
}