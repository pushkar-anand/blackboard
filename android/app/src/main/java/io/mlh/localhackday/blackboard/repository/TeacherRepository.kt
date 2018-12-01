package io.mlh.localhackday.blackboard.repository

import android.app.Application
import android.os.AsyncTask
import io.mlh.localhackday.blackboard.api.TeachersAPI
import io.mlh.localhackday.blackboard.api.Urls
import io.mlh.localhackday.blackboard.data.Teacher
import io.mlh.localhackday.blackboard.db.BlackboardDatabase
import io.mlh.localhackday.blackboard.db.TeacherDao
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class TeacherRepository(application: Application) {
    private  var teacherDao: TeacherDao? = null
    private  var retroService: TeachersAPI? = null
    init {
        retroService =
                Retrofit.Builder()
                    .baseUrl(Urls.API_BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
                    .create(TeachersAPI::class.java)

        val database = BlackboardDatabase.getDatabase(application)
    }

    fun getLoginResults(email: String, password: String): Call<Teacher> {
        //val x = retroService.getLoginResults(email, password)
        //return GetLoginResults(retroService).execute(x).get()

        return retroService!!.getLoginResults(email,password)
    }
    fun insert(teacher: Teacher){
        InsertAsyncTask(teacherDao).execute(teacher)
    }
    private companion object {
        class InsertAsyncTask(dao: TeacherDao?) : AsyncTask<Teacher, Void, Void>() {
            private var dao: TeacherDao? = dao

            override fun doInBackground(vararg params: Teacher): Void? {
                val teacher = params[0]
                dao?.insert(teacher)
                return null
            }
        }

    }
}