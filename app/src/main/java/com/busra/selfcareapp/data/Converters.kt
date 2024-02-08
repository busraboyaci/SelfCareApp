package com.busra.selfcareapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.LocalDate

object Converters {
    @TypeConverter
    @JvmStatic
    fun fromDate(date: LocalDate?): String? {
        return date?.toString()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    @JvmStatic
    fun toDate(dateString: String?): LocalDate? {
        return dateString?.let { LocalDate.parse(it) }
    }
}