package com.busra.selfcareapp.data.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "habit_completion_table",
    foreignKeys = [ForeignKey(entity = HabitDbModel::class, parentColumns = ["id"], childColumns = ["habit_id"], onDelete = ForeignKey.CASCADE)])
data class HabitCompletion(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "habit_id") val habitId: Int,
    @ColumnInfo(name = "completion_date") val completionDate: LocalDate
)
