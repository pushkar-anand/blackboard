package io.mlh.localhackday.blackboard.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.mlh.localhackday.blackboard.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun setupListeners() {

        login_btn.setOnClickListener {

        }

    }
}
