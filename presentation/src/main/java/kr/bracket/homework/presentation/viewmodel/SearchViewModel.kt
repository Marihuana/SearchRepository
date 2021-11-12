package kr.bracket.homework.presentation.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.bracket.homework.domain.model.RepoVO


class SearchViewModel () : BaseViewModel() {
    private val inputText = ObservableField("")

    private val _items = MutableLiveData<List<RepoVO>>()
    val items : LiveData<List<RepoVO>> get() = _items

    fun search(){
        val query = inputText.get()?.trim()

        //search with use case

    }

}