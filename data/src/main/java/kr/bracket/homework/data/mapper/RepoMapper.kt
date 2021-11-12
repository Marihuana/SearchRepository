package kr.bracket.homework.data.mapper

import kr.bracket.homework.data.entity.RepoDTO
import kr.bracket.homework.data.entity.ResponseDTO
import kr.bracket.homework.domain.model.RepoVO

object RepoMapper {
    fun transform(response : ResponseDTO<RepoDTO>) : List<RepoVO>{
        return response.items.map { it }
    }
}