package com.example.fragmentapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AppsAdapter(
    private val list: List<App>
) : RecyclerView.Adapter<AppsAdapter.CustomViewHolder>() {

    class CustomViewHolder(
        val view : View
    ) : RecyclerView.ViewHolder(view) {
        val txtId : TextView = view.findViewById(R.id.textView2)
        val txtCnt : TextView = view.findViewById(R.id.textView4)
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.apps_item,
                parent,
                false
            )
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val (id, cnt) = list.get(position) // destructuring

        holder.txtId.text = "$id"
        holder.txtCnt.text = "$cnt"
    }

}