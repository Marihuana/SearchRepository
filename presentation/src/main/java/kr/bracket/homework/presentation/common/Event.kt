package kr.bracket.homework.presentation.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

open class Event<out T>(private val content : T){
    private var isHandled = false

    fun getContent() : T? {
        return if(isHandled){
            null
        }else {
            isHandled = true
            content
        }
    }

    fun peekContent(): T = content
}

fun <T> LiveData<Event<T>>.observeEvent(owner : LifecycleOwner, listener : (T) -> Unit) {
    observe(owner){ it.getContent()?.also(listener) }
}