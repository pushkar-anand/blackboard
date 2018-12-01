package io.mlh.localhackday.blackboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.mlh.localhackday.blackboard.R
import kotlinx.android.synthetic.main.activity_upload.*

class UploadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)
    }

    private fun setupListeners(){
        uploadBtn.setOnClickListener {

        }

        notifyBtn.setOnClickListener {

        }
    }
}
