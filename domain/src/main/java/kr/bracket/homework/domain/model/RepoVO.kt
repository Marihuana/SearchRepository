package kr.bracket.homework.domain.model

interface RepoVO {
    val name : String
    val fullName : String
    val description : String?
    val topics : List<String>
    val stargazersCount : Double
    val language : String?
    val updatedAt : Long?
}