package io.mlh.localhackday.blackboard.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.mlh.localhackday.blackboard.data.Teacher

@Dao
interface TeacherDao {
    @Insert
    fun insert(teacher: Teacher)

    @Update
    fun update(vararg teacher: Teacher)

    @Query("SELECT * FROM teachers WHERE email = :email")
    fun get(email: String): LiveData<Teacher>

    @Query("SELECT * FROM teachers")
    fun getAll(): LiveData<List<Teacher>>
}