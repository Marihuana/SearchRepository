package kr.bracket.homework.presentation.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.bracket.homework.domain.model.RepoVO
import kr.bracket.homework.domain.repository.GithubRepository
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: GithubRepository) : BaseViewModel() {
    val inputText = ObservableField("")

    private val _items = MutableLiveData<List<RepoVO>>()
    val items : LiveData<List<RepoVO>> get() = _items

    fun search(){
        val query = inputText.get()?.trim()

        //search with use case

    }

}