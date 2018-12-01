package io.mlh.localhackday.blackboard.ui

import android.os.Bundle
import android.app.Activity
import io.mlh.localhackday.blackboard.R

import kotlinx.android.synthetic.main.activity_students_home.*

class StudentsHomeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_home)
    }

}
