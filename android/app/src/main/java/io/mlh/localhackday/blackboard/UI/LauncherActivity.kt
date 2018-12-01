package io.mlh.localhackday.blackboard.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.mlh.localhackday.blackboard.R
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
    }
    fun setupListeners()
    {
       student.setOnClickListener {
           val intent = Intent(this, LoginActivity::class.java)
           startActivity(intent)
        teacher.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
       }
    }
}

