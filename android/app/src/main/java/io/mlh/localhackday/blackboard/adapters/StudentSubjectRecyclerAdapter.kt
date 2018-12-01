package io.mlh.localhackday.blackboard.adapters

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import io.mlh.localhackday.blackboard.R
import io.mlh.localhackday.blackboard.data.Subjects
import java.security.AccessControlContext


class StudentSubjectRecyclerAdapter(context: Context) :
    RecyclerView.Adapter<StudentSubjectRecyclerAdapter.SubjectViewHolder>() {


    companion object {
        val width = Resources.getSystem().displayMetrics.widthPixels
    }

    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var subjects: List<Subjects>? = null
    private var onSubjectClickListener: OnSubjectClickListener? = null

    class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val SubjectItemCard: MaterialCardView = itemView.findViewById(R.id.subject_Item_Card)
        val subjectNameTV: TextView = itemView.findViewById(R.id.subject_name)
    }

    interface OnSubjectClickListener{
        fun onClick(subject: Subjects)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val  itemView = mInflater.inflate(R.layout.student_subject_item, parent, false)
        return SubjectViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return if(subjects != null){
            subjects!!.size
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        if (subjects != null){
            val subject = subjects!![position]
            holder.subjectNameTV.text = subject.subjectName

            holder.SubjectItemCard.setOnClickListener {
                onSubjectClickListener?.onClick(subject)
            }
        }
    }

    fun setOnSubjectClickListener(onSubjectClickListener: OnSubjectClickListener){
        this.onSubjectClickListener = onSubjectClickListener
    }

    fun setSubjects(subjects: List<Subjects>){
        this.subjects = subjects
        notifyDataSetChanged()
    }
}