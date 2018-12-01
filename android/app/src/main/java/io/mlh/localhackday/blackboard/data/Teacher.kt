package io.mlh.localhackday.blackboard.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "teachers"
)
data class Teacher(
    @PrimaryKey(autoGenerate = false)
    val teachersID:Long,

    val name: String,
    val email: String,
    val password: String,
    val semesters: String,
    val token: String,
    val tokenGen: String
) {
}