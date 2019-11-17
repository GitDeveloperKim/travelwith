package com.chicken.toyproject.travelwith.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chicken.toyproject.travelwith.R
import kotlinx.android.synthetic.main.myschedule_list_item.view.*

class MyScheduleAdapter (
    val items : ArrayList<String>,
    val context : Context?
) : RecyclerView.Adapter <ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.myschedule_list_item,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvDataType.text = items[position]
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvDataType = view.testText!!
}