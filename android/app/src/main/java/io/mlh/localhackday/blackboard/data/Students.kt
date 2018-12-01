package io.mlh.localhackday.blackboard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "students"
)

data class Students(
    @PrimaryKey(autoGenerate = false)
    val studentID:Long,

    val name:String,
    val email:String,
    val password: String,
    val semesterID: Long,
    val token: String,
    val tokenGen: String

) {

}