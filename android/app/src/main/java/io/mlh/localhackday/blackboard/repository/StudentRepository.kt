package io.mlh.localhackday.blackboard.repository

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

    fun getLoginResults(email: String, password: String): Call<Student>{
        return retroService.getLoginResults(email, password)
    }
}