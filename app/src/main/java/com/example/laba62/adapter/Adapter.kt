package com.example.laba62.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.laba62.R
import com.example.laba62.ListFragment
import com.example.laba62.Patient

class Adapter(private val patients: ArrayList<Patient>, val context: Context, val callback: ListFragment) :

    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = patients[position].name
        holder.lastName.text = patients[position].lastName
        holder.age.text = patients[position].age
        holder.sex.text = patients[position].sex
        holder.itemRoot.setOnClickListener { callback.onItemSelected(position) }
    }

    override fun getItemCount(): Int {
        return patients.size
    }
}

class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.findViewById<TextView>(R.id.listNameTextView)
    val lastName = itemView.findViewById<TextView>(R.id.listLastNameTextView)
    val age = itemView.findViewById<TextView>(R.id.listAgeTextView)
    val sex = itemView.findViewById<TextView>(R.id.listSexTextView)
    val itemRoot = itemView.findViewById<ConstraintLayout>(R.id.ListItemRoot)
}
interface Callback{
    fun onItemSelected(i: Int)
}