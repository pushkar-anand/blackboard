package io.mlh.localhackday.blackboard.api

import io.mlh.localhackday.blackboard.data.Semesters
import io.mlh.localhackday.blackboard.data.Student
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface StudentsAPI {

    @FormUrlEncoded
    @POST("/student/login")
    fun getLoginResults(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Student>

    @GET("/student/details/semester")
    fun getSemesterDetails(
        @Field("email") email: String,
        @Field("token") token: String
    ): Call<Semesters>
}