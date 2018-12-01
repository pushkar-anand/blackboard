package io.mlh.localhackday.blackboard.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.mlh.localhackday.blackboard.data.Subjects


@Dao
interface SubjectDao {

    @Insert
    fun insert(subject: Subjects)

    @Update
    fun update(vararg subject: Subjects)

    @Query("SELECT * FROM subjects WHERE subjectID = :subjectID")
    fun get(subjectID: Long): LiveData<Subjects>

    @Query("SELECT * FROM subjects")
    fun getAll(): LiveData<List<Subjects>>

}