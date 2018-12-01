package io.mlh.localhackday.blackboard.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.mlh.localhackday.blackboard.data.Semesters


@Dao
interface SemesterDao {
    @Insert
    fun insert(semester: Semesters)

    @Update
    fun update(vararg semester: Semesters)

    @Query("SELECT * FROM semesters WHERE semesterID = :semesterID")
    fun get(semesterID: Long): LiveData<Semesters>

    @Query("SELECT * FROM semesters")
    fun getAll(): LiveData<List<Semesters>>
}