package kr.bracket.homework.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kr.bracket.homework.data.datasource.GithubService
import kr.bracket.homework.domain.model.RepoVO
import kr.bracket.homework.domain.repository.GithubRepository
import javax.inject.Inject

@ExperimentalCoroutinesApi
class GithubRepositoryImpl @Inject constructor(private val service : GithubService): GithubRepository {
    private val pageSize = 30

    override fun searchRepositories(query: String): Flowable<PagingData<RepoVO>> {
        val fixed = "$query$QUERY_SUFFIX"

        return Pager(PagingConfig(pageSize)){
            RepoPagingSource(fixed, service)
        }.flowable
    }

    companion object {
        const val QUERY_SUFFIX = " in:name"
    }
}