package kr.bracket.homework.domain.repository

import androidx.paging.PagingData
import io.reactivex.rxjava3.core.Flowable
import kr.bracket.homework.domain.model.RepoVO

interface GithubRepository {
    fun searchRepositories(query : String) : Flowable<PagingData<RepoVO>>
}