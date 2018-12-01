package io.mlh.localhackday.blackboard.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import io.mlh.localhackday.blackboard.api.StudentsAPI
import io.mlh.localhackday.blackboard.api.Urls
import io.mlh.localhackday.blackboard.data.Student
import io.mlh.localhackday.blackboard.db.BlackboardDatabase
import io.mlh.localhackday.blackboard.db.StudentDao
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class StudentRepository(application: Application) {

    private var studentDao: StudentDao? = null
    private var retroService: StudentsAPI? = null

    init {
         retroService =
            Retrofit.Builder()
                .baseUrl(Urls.API_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(StudentsAPI::class.java)

        val database = BlackboardDatabase.getDatabase(application)
        studentDao = database!!.studentDao()

    }

    fun getLoginResults(email: String, password: String): Call<Student> {
        //val x = retroService.getLoginResults(email, password)
        //return GetLoginResults(retroService).execute(x).get()

        return retroService!!.getLoginResults(email, password)
    }

    fun insert(student: Student) {
        InsertAsyncTask(studentDao).execute(student)
    }

    fun get(email: String) : LiveData<Student>? {
        return studentDao?.get(email)
    }


    private companion object {

        class InsertAsyncTask(private var dao: StudentDao?) : AsyncTask<Student, Void, Void>() {

            override fun doInBackground(vararg params: Student): Void? {
                val student = params[0]
                dao?.insert(student)
                return null
            }
        }

    }
}