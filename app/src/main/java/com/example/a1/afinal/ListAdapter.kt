package com.example.a1.afinal

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.add_new_contact.view.*
import kotlinx.android.synthetic.main.post_item_activity.view.*

class ListAdapter(var posts: List<Post>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = posts[position].title
        holder.body.text = posts[position].body
        holder.mobile_number.text = posts [position].mobile_number
        holder.home_number.text = posts [position].home_number
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.post_item_activity, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }


    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        var title: TextView = itemView!!.Edit_id
        var body: TextView = itemView!!.Edit_name
        var mobile_number: TextView = itemView!!.Edit_mobile_number
        var home_number: TextView = itemView!!.Edit_home_number


    }
}