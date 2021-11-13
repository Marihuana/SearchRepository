package kr.bracket.homework.data.repository

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.bracket.homework.data.datasource.GithubService
import kr.bracket.homework.data.entity.RepoDTO
import kr.bracket.homework.data.entity.ResponseDTO
import kr.bracket.homework.domain.model.RepoVO

class RepoPagingSource(
    private val query : String,
    private val service: GithubService
) : RxPagingSource<Int, RepoVO>() {
    private val pageSize = 30

    override fun getRefreshKey(state: PagingState<Int, RepoVO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, RepoVO>> {
        val page = params.key ?: 1
        return service.getRepositories(query, page)
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(page, it) }
            .onErrorReturn { LoadResult.Error(it) }
    }

    private fun toLoadResult(page : Int, res : ResponseDTO<RepoDTO>) : LoadResult<Int, RepoVO>{
        return LoadResult.Page(
            data = res.items,
            prevKey = null,
            nextKey = if(res.items.size < pageSize) null else page + 1
        )
    }
}