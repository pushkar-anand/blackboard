package io.mlh.localhackday.blackboard.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "subjects"
)
data class Subjects(
    @PrimaryKey(autoGenerate = false)
    val subjectID: Long,

    val subjectName: String,
    val subjectCode: String
) {
}