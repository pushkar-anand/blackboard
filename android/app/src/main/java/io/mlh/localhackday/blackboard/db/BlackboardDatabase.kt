package io.mlh.localhackday.blackboard.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.mlh.localhackday.blackboard.data.Semesters
import io.mlh.localhackday.blackboard.data.Student
import io.mlh.localhackday.blackboard.data.Subjects
import io.mlh.localhackday.blackboard.data.Teacher

@Database(entities = [Student::class, Teacher::class, Subjects::class, Semesters::class], version = 1)
abstract class BlackboardDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun teacherDao(): TeacherDao
    abstract fun subjectDao(): SubjectDao
    abstract fun semesterDao(): SemesterDao

    companion object {

        @Volatile
        private var INSTANCE: BlackboardDatabase? = null

        internal fun getDatabase(context: Context): BlackboardDatabase? {
            if (INSTANCE == null) {
                synchronized(Database::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            BlackboardDatabase::class.java, "blackboard.db"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }

    }
}