package io.mlh.localhackday.blackboard.ui

import android.os.Bundle
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import io.mlh.localhackday.blackboard.R
import io.mlh.localhackday.blackboard.adapters.StudentSubjectRecyclerAdapter
import io.mlh.localhackday.blackboard.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.activity_students_home.*
import kotlinx.android.synthetic.main.content_student_home.*


class StudentsHomeActivity : AppCompatActivity() {

    private var studentViewModel: StudentViewModel? = null
    private var subjectAdapter: StudentSubjectRecyclerAdapter? = null

    companion object {
        const val STUDENT_INTENT_EXTRA = "student"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_home)
        setupRecyclerView()
        initViewModel()
    }

    private fun setupRecyclerView() {
        subjectAdapter = StudentSubjectRecyclerAdapter(this)
        subject_recycler.adapter = subjectAdapter
        subject_recycler.layoutManager = GridLayoutManager(this, 2)
    }

    private fun initViewModel() {
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)
    }

    private fun setupObservers() {
        studentViewModel?.get(intent.getStringExtra(STUDENT_INTENT_EXTRA))?.observe(this, Observer {

        })
    }


}
