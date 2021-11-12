package kr.bracket.homework.presentation.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import androidx.paging.rxjava3.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kr.bracket.homework.domain.model.RepoVO
import kr.bracket.homework.domain.repository.GithubRepository
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: GithubRepository) : BaseViewModel() {
    val inputText = ObservableField("")

    private val _items = MutableLiveData<PagingData<RepoVO>>()
    val items : LiveData<PagingData<RepoVO>> get() = _items

    @ExperimentalCoroutinesApi
    fun search(){
        val query = inputText.get()?.trim()

        query?.also {
            if(it.isNotEmpty()){
                val disposable = repository.searchRepositories(query)
                    .cachedIn(viewModelScope)
                    .doOnNext { data ->
                        data.map { repo ->
                            Log.d("result", repo.name)
                        }
                    }
                    .subscribe(::onSuccess, ::onError)

                addDispose(disposable)
            }
        }
    }

    private fun onSuccess(data : PagingData<RepoVO>){
        _items.value = data
    }

}