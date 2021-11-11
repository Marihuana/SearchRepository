package kr.bracket.homework.domain.repository

import io.reactivex.rxjava3.core.Single
import kr.bracket.homework.domain.model.RepoVO

interface GithubRepository {
    fun searchRepositories(query : String) : Single<List<RepoVO>>
}