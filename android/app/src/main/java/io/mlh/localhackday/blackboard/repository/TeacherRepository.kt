package io.mlh.localhackday.blackboard.repository

import android.app.Application
import android.provider.ContactsContract
import io.mlh.localhackday.blackboard.api.TeachersAPI
import io.mlh.localhackday.blackboard.api.Urls
import io.mlh.localhackday.blackboard.data.Teacher
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class TeacherRepository(application: Application) {
    private val retroService =
            Retrofit.Builder()
                .baseUrl(Urls.API_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(TeachersAPI::class.java)
    fun getLoginResults(email: String, password: String): Call<Teacher> {
        return retroService.getLoginResults(email,password)
    }
}