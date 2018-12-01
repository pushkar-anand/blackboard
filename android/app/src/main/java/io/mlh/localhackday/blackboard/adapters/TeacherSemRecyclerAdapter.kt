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
import io.mlh.localhackday.blackboard.data.Semesters
import io.mlh.localhackday.blackboard.data.Subjects

abstract class TeacherSemRecyclerAdapter(context: Context) :
    RecyclerView.Adapter<TeacherSemRecyclerAdapter.SemViewHolder>() {
    companion object {
        val width = Resources.getSystem().displayMetrics.widthPixels
    }

    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var semesters: List<Semesters>? = null
    private var onSemClickListener: OnSemClickListener? = null

    class SemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val SemItemCard: MaterialCardView = itemView.findViewById(R.id.semester_Item_Card)
        val semesterTV: TextView = itemView.findViewById(R.id.semester)
    }

    interface OnSemClickListener{
        fun onClick(semester: Semesters)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SemViewHolder {
        val  itemView = mInflater.inflate(R.layout.teacher_sem_item, parent, false)
        return SemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return if(semesters != null){
            semesters!!.size
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: SemViewHolder, position: Int) {
        if (semesters != null){
            val semester = semesters!![position]
            holder.semesterTV.text = semester.Semester.toString()

            holder.SemItemCard.setOnClickListener {
                onSemClickListener?.onClick(semester)
            }
        }
    }

    fun setOnSubjectClickListener(onSubjectClickListener: OnSemClickListener){
        this.onSemClickListener = onSubjectClickListener
    }

    fun setSubjects(subjects: List<Subjects>){
        this.semesters = semesters
        notifyDataSetChanged()
    }
}
