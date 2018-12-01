package io.mlh.localhackday.blackboard.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.mlh.localhackday.blackboard.data.Student

@Dao
interface StudentDao {

    @Insert
    fun insert(student: Student)

    @Update
    fun update(vararg student: Student)

    @Query("SELECT * FROM students WHERE email = :email")
    fun get(email: String): LiveData<Student>

    @Query("SELECT * FROM students")
    fun getAll(email: String): LiveData<List<Student>>
}