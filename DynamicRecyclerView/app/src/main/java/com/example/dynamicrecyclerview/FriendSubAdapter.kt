package com.example.dynamicrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamicrecyclerview.databinding.ItemSubSectionBinding

/**
 * Class: FriendSubAdapter
 * Created by ywsong on 2022/01/04.
 * Description:
 */

class FriendSubAdapter(private val friendList: List<Friend>) : RecyclerView.Adapter<FriendSubAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemSubSectionBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(friendList[position])
    }

    override fun getItemCount() = friendList.size

    class MyViewHolder(private val binding: ItemSubSectionBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(friend: Friend) {
            with(binding) {
                txtName.text = friend.name
                txtAge.text = "${friend.age}"
                txtPhone.text = friend.phone
            }
        }

    }

}