package io.mlh.localhackday.blackboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.mlh.localhackday.blackboard.R
import kotlinx.android.synthetic.main.activity_upload.*
import android.widget.Toast
import android.content.Intent



class UploadActivity : AppCompatActivity() {

    private val FILE_SELECT_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)
    }

    private fun setupListeners(){
        uploadBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "*/*"
            intent.addCategory(Intent.CATEGORY_OPENABLE)

            try {
                startActivityForResult(
                    Intent.createChooser(intent, "Select a File to Upload"),
                    FILE_SELECT_CODE
                )
            } catch (ex: android.content.ActivityNotFoundException) {
                // Potentially direct the user to the Market with a Dialog
                Toast.makeText(
                    this, "Please install a File Manager.",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        notifyBtn.setOnClickListener {
            Toast.makeText(this, "Coming Soon!!", Toast.LENGTH_SHORT).show()
        }
    }
}
