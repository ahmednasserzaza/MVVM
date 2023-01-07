package com.example.mvvm.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.repository.Repository
import com.example.mvvm.model.domain.User
import com.example.mvvm.model.domain.Wisdom
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MainViewModel : ViewModel() {

    private val repository = Repository()
    private val disposable = CompositeDisposable()

    // Encapsulate data because i don't want any one to edit it from MainActivity(immutable LiveData)
    private var _currentUser = MutableLiveData<User>()
    val currentUser: LiveData<User>
        get() = _currentUser

    // Encapsulate data because i don't want any one to edit it from MainActivity(immutable LiveData)
    private var _wisdom = MutableLiveData<Wisdom>()
    val wisdom: LiveData<Wisdom>
        get() = _wisdom

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        _currentUser.postValue(repository.getCurrentUser())
    }

    fun getAWisdom() {
//        _wisdom.postValue(repository.getRandomWisdom())

        // using RxJava
        disposable.add(
            repository.getRxRandomWisdom()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetWisdomSuccess, ::onGetWisdomError)
        )

    }

    private fun onGetWisdomSuccess(wisdom: Wisdom) {
        _wisdom.postValue(wisdom)
    }

    private fun onGetWisdomError(throwable: Throwable) {
        throw Exception(throwable.message)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

}