package com.mungaicodes.roomdemoapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mungaicodes.roomdemoapp.R
import com.mungaicodes.roomdemoapp.data.User
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter() : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()
//    private val layoutInflater = LayoutInflater.from(parent.context)

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val theView = layoutInflater.inflate(R.layout.custom_row, parent, false)
//        return MyViewHolder(theView)
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.id_text.text = currentItem.id.toString()
        holder.itemView.first_name_text.text = currentItem.firstName.toString()
        holder.itemView.last_name_text.text = currentItem.lastName.toString()
        holder.itemView.age_text.text = currentItem.age.toString()
    }

    override fun getItemCount() = userList.size

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}