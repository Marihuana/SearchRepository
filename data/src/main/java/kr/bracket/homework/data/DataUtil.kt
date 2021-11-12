package kr.bracket.homework.data

import java.text.SimpleDateFormat
import java.util.*

object DataUtil {
    private const val ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    private val sdf = SimpleDateFormat(ISO_8601_FORMAT, Locale.getDefault())

    fun dateStringToLong(date : String) : Long?{
        return sdf.parse(date)?.time
    }
}

