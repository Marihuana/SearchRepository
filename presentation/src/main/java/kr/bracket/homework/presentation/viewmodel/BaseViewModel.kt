package kr.bracket.homework.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import kr.bracket.homework.presentation.common.Event

open class BaseViewModel : ViewModel() {
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()
    private val _errorObserver = MutableLiveData<Event<String>>()
    val errorObserver : LiveData<Event<String>> = _errorObserver

    protected fun addDispose(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    private fun disposeAll(){
        compositeDisposable.run {
            if(!isDisposed) dispose()
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposeAll()
    }

    protected fun onError(t : Throwable){
        Log.e("error", t.stackTraceToString())
    }
}