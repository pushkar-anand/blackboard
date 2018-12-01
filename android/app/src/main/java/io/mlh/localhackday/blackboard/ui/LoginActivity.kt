package io.mlh.localhackday.blackboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import io.mlh.localhackday.blackboard.R
import io.mlh.localhackday.blackboard.data.Student
import io.mlh.localhackday.blackboard.data.Teacher
import io.mlh.localhackday.blackboard.repository.StudentRepository
import io.mlh.localhackday.blackboard.repository.TeacherRepository
import io.mlh.localhackday.blackboard.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    private var studentViewModel:  StudentViewModel? = null
    companion object {
        const val LOGIN_TYPE_INTENT_EXTRA = "login.type"
        const val LOGIN_TYPE_INTENT_STUDENT = "login.type.student"
        const val LOGIN_TYPE_INTENT_TEACHER = "login.type.teacher"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViewModel()
        setupListeners()
    }

    private fun initViewModel() {
        ViewModelProviders.of(this).get(StudentViewModel::class.java)
    }

    private fun setupListeners() {

        login_btn.setOnClickListener {

            val email = emailInput.editText?.text.toString().trim()
            val password = passwordInput.editText?.text.toString().trim()

            when {
                email.isEmpty() -> emailInput.error = "Enter email"
                password.isEmpty() -> passwordInput.error = "Enter Password"
                else -> {

                    //val student = studentViewModel?.getLoginResults(email, password)
                    //Log.d("test",student.toString())
                    if(intent.getStringExtra(LOGIN_TYPE_INTENT_EXTRA) == LOGIN_TYPE_INTENT_STUDENT) {
                            val loginCall = StudentRepository(application).getLoginResults(email, password)

                            loginCall.enqueue(object : Callback<Student> {
                                override fun onFailure(call: Call<Student>, t: Throwable) {
                                    Log.d("test", "failed" + t.message)
                                    t.printStackTrace()
                                }

                                override fun onResponse(call: Call<Student>, response: Response<Student>) {
                                    if(response.code() == 200) {
                                        Log.d("test", response.body().toString())
                                    } else {
                                        Log.d("errorCode", response.code().toString())
                                    }
                                }

                            })
                    } else {
                        val loginCall = TeacherRepository(application).getLoginResults(email, password)

                        loginCall.enqueue(object : Callback<Teacher> {
                            override fun onFailure(call: Call<Teacher>, t: Throwable) {
                                Log.d("test", "failed" + t.message)
                                t.printStackTrace()
                            }

                            override fun onResponse(call: Call<Teacher>, response: Response<Teacher>) {
                                if(response.code() == 200) {
                                    Log.d("test", response.body().toString())
                                } else {
                                    Log.d("errorCode", response.code().toString())
                                }
                            }

                        })
                    }
                }
            }

        }

    }
}
