package io.mlh.localhackday.blackboard.repository

import android.os.AsyncTask
import io.mlh.localhackday.blackboard.api.StudentsAPI
import io.mlh.localhackday.blackboard.api.Urls
import io.mlh.localhackday.blackboard.data.Student
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class StudentRepository {
    private val retroService =
            Retrofit.Builder()
                .baseUrl(Urls.API_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(StudentsAPI::class.java)

    fun getLoginResults(email: String, password: String): Student? {
        return GetLoginResults(retroService).get()
    }


    private companion object {

        class GetLoginResults(studentRetro: StudentsAPI): AsyncTask<Call<Student>, Void, Student>() {

            override fun doInBackground(vararg params: Call<Student>?): Student {
                val call = params[0];
                return call?.execute()?.body()!!
            }

        }

    }
}