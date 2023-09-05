package com.busra.selfcareapp.data.roomdb

import android.graphics.Bitmap
import android.graphics.drawable.Icon
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HabitDbModel(
    val habitName: String,
    val habitDescription: String,
    val backgroundColor: Int,
    @ColumnInfo(name = "icon_res_id") val iconResName: String, // PNG dosya adı
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
    
)