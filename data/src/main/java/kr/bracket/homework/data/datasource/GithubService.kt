package kr.bracket.homework.data.datasource

import io.reactivex.rxjava3.core.Single
import kr.bracket.homework.data.entity.RepoDTO
import kr.bracket.homework.data.entity.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories")
    fun getRepositories(@Query("q") query : String,
                        @Query("page") page : Int,
                        @Query("per_page") perPage : Int = 30) : Single<ResponseDTO<RepoDTO>>
}