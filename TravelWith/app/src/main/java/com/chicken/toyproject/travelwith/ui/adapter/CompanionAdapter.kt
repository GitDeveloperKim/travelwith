package com.chicken.toyproject.travelwith.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chicken.toyproject.travelwith.R
import kotlinx.android.synthetic.main.companion_list_item.view.*

class CompanionAdapter(
    var items: ArrayList<String>,
    var context: Context?
) : RecyclerView.Adapter<ViewHolderCompanion>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCompanion {
        return ViewHolderCompanion(
            LayoutInflater.from(context).inflate(
                R.layout.companion_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolderCompanion, position: Int) {
        holder.tvDataType.text = items[position]
    }
}

class ViewHolderCompanion(view: View) : RecyclerView.ViewHolder(view) {
    val tvDataType = view.companionText!!
}