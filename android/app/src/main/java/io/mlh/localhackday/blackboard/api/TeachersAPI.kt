package io.mlh.localhackday.blackboard.api

import io.mlh.localhackday.blackboard.data.Teacher
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TeachersAPI {
        @FormUrlEncoded
        @POST("/teachers/login")
        fun getLoginResults(
            @Field("email") email: String,
            @Field("password") password: String
        ): Call<Teacher>
}
