package kr.bracket.homework.domain.model

import java.io.Serializable

interface RepoVO : Serializable {
    val name : String
    val fullName : String
    val description : String?
    val topics : List<String>
    val stargazersCount : String
    val license : String?
    val language : String?
    val updatedAt : String
}