package com.example.mvvm.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.repository.Repository
import com.example.mvvm.model.domain.User
import com.example.mvvm.model.domain.Wisdom

class MainViewModel : ViewModel() {

    private val repository = Repository()

    // Encapsulate data because i don't want any one to edit it from MainActivity(immutable LiveData)
    private var _currentUser = MutableLiveData<User>()
    val currentUser: LiveData<User>
        get() = _currentUser

    // Encapsulate data because i don't want any one to edit it from MainActivity(immutable LiveData)
    private var _wisdom = MutableLiveData<Wisdom>()
    val wisdom:LiveData<Wisdom>
    get() = _wisdom

    fun getUserInfo() {
        _currentUser.postValue(repository.getCurrentUser())
    }

    fun getAWisdom() {
        _wisdom.postValue(repository.getRandomWisdom())
    }
}