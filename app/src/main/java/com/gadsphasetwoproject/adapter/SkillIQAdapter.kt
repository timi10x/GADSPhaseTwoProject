package com.gadsphasetwoproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gadsphasetwoproject.R
import com.gadsphasetwoproject.model.UserIq


class SkillIQAdapter(private val context: Context) :
    RecyclerView.Adapter<SkillIQAdapter.MyViewHolder>() {

    private var UserIqList: List<UserIq> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.leader_board_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return UserIqList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = UserIqList[position]
        holder.name.text = item.name
        holder.no_of_hours.text = item.score.toString()
        holder.address.text = item.country
        val badgeUrl = item.badgeUrl

        Glide.with(context)
            .load(badgeUrl)
            .placeholder(R.drawable.empty_img)
            .error(R.drawable.empty_img)
            .into(holder.badgeImage)
    }

    fun setUserIqIqListItems(UserIqList: List<UserIq>) {
        this.UserIqList = UserIqList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        var name: TextView = itemView!!.findViewById(R.id.name_tv)
        var no_of_hours: TextView = itemView!!.findViewById(R.id.no_hours_tv)
        var address: TextView = itemView!!.findViewById(R.id.address_tv)
        var badgeImage: ImageView = itemView!!.findViewById(R.id.badge_imageView)

    }
}
