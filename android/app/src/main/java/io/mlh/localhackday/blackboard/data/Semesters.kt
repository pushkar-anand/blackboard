package io.mlh.localhackday.blackboard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "semesters"
)
data class Semesters(
    @PrimaryKey(autoGenerate = false)
    val semesterID: Long,

    val Semester: Short,
    val section: Char,
    val subjects: String
) {

}