package kr.bracket.homework.data.entity

import android.icu.text.RelativeDateTimeFormatter
import android.os.Build
import android.text.format.DateUtils
import androidx.annotation.RequiresApi
import kr.bracket.homework.domain.model.RepoVO
import com.google.gson.annotations.SerializedName
import kr.bracket.homework.data.DataUtil
import java.io.Serializable

data class RepoDTO(
    @SerializedName("name")
    private val _name : String,

    @SerializedName("full_name")
    val _fullName : String,

    @SerializedName("description")
    private val _description : String?,

    @SerializedName("topics")
    private val _topics : List<String>,

    @SerializedName("license")
    private val _license : LicenseDTO?,

    @SerializedName("stargazers_count")
    private val _stargazersCount : Double,

    @SerializedName("language")
    private val _language : String?,

    @SerializedName("updated_at")
    private val _updatedAt : String,

    @SerializedName("html_url")
    private val _url : String
)
 : RepoVO {
    override val name: String
        get() = _name

    override val fullName: String
        get() = _fullName

    override val description: String?
        get() = _description

    override val topics: List<String>
        get() = _topics

    override val license: String?
        get() = _license?.name

    override val stargazersCount: String
        get() = if(_stargazersCount < 1000) "${_stargazersCount.toInt()}" else String.format("%.1f k",_stargazersCount / 1000)

    override val language: String?
        get() = _language

    override val updatedAt: Long?
        get() = DataUtil.dateStringToLong(_updatedAt)
}

data class ResponseDTO<T> (
    @SerializedName("total_count") val total : Long,
    @SerializedName("incomplete_results") val incompleteResults : Boolean,
    @SerializedName("items") val items : List<T>
)

data class LicenseDTO(
    val name : String
) : Serializable