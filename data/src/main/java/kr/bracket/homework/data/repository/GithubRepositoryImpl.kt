package kr.bracket.homework.data.repository

import io.reactivex.rxjava3.core.Single
import kr.bracket.homework.data.datasource.GithubService
import kr.bracket.homework.data.mapper.RepoMapper
import kr.bracket.homework.domain.model.RepoVO
import kr.bracket.homework.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(private val service : GithubService): GithubRepository {
    private val pageSize = 30

    override fun searchRepositories(query: String): Single<List<RepoVO>> {
        val fixed = "$query$QUERY_SUFFIX"

        return service.getRepositories(fixed, 1, pageSize)
            .map(RepoMapper::transform)
    }

    companion object {
        const val QUERY_SUFFIX = " in:name"
    }
}