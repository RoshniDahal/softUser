package com.roshni.softuser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.roshni.softuser.R
import com.roshni.softuser.Storage
import com.roshni.softuser.fragments.HomeFragment
import com.roshni.softuser.model.Student

class StudentAdapter(
        val lstStudent: ArrayList<Student>,
        val context: HomeFragment

) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private var storage =  Storage()

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imgStudent: ImageView
        val imgDelete: ImageView
        val tvName: TextView
        val tvAge: TextView
        val tvAddress: TextView
        val tvGender: TextView

        init {
            imgStudent = view.findViewById(R.id.imgProfile)
            imgDelete = view.findViewById(R.id.imgDelete)
            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.student_information,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        val student = lstStudent[position]
        holder.tvName.text = student.fullName
        holder.tvAge.text = student.age
        holder.tvAddress.text = student.address
        holder.tvGender.text = student.gender


        holder.imgDelete.setOnClickListener {
            storage.deleteStudent(student)
            notifyItemRemoved(position)
        }

        //Load image with Glide library
        Glide.with(context)
                .load(student.userImageURL)
                .into(holder.imgStudent)
    }

    override fun getItemCount(): Int {
        return lstStudent.size
    }
}