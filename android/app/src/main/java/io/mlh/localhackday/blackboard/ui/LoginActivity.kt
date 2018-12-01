package io.mlh.localhackday.blackboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import io.mlh.localhackday.blackboard.R
import io.mlh.localhackday.blackboard.data.Student
import io.mlh.localhackday.blackboard.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    private var studentViewModel:  StudentViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViewModel()
        setupListeners()
    }

    fun initViewModel() {
        ViewModelProviders.of(this).get(StudentViewModel::class.java)
    }

    fun setupListeners() {

        login_btn.setOnClickListener {

            val email = emailInput.editText?.text.toString().trim()
            val password = passwordInput.editText?.text.toString().trim()

            if(email.isEmpty() ) {
                emailInput.error = "Enter email";
            } else if ( password.isEmpty() ) {
                passwordInput.error = "Enter Password";
            } else {

                val student = studentViewModel?.getLoginResults(email, password)

            }

        }

    }
}
