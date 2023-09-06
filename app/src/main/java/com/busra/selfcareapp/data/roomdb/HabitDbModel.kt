package com.busra.selfcareapp.data.roomdb

import android.graphics.Bitmap
import android.graphics.drawable.Icon
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HabitDbModel(
    var habitName: String,
    var habitDescription: String,
    var backgroundColor: Int,
    @ColumnInfo(name = "icon_res_id") var iconResName: String, // PNG dosya adı
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
    
)