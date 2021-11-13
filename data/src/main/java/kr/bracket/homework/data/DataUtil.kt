package kr.bracket.homework.data

import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*

object DataUtil {
    private const val ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    private val sdf = SimpleDateFormat(ISO_8601_FORMAT, Locale.US)

    private fun dateStringToLong(date : String) : Long?{
        return sdf.parse(date)?.time
    }

    fun dateStringToRelativeDateString(date : String) : String?{
        return dateStringToLong(date)?.let { moment ->
            DateUtils.getRelativeTimeSpanString(
                moment,
                System.currentTimeMillis(),
                DateUtils.MINUTE_IN_MILLIS
            ).let {
                "updated${if(!it.contains("ago"))" on " else " "}${it}"
            }
        } ?: null
    }
}

