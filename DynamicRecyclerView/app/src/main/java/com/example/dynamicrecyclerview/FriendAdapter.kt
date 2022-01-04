package com.example.dynamicrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamicrecyclerview.databinding.ItemSectionBinding

/**
 * Class: FriendAdapter
 * Created by ywsong on 2022/01/04.
 * Description:
 */

class FriendAdapter(private val friendModelList: List<SectionModel>) : RecyclerView.Adapter<FriendAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemSectionBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(friendModelList[position])
    }

    override fun getItemCount() = friendModelList.size

    class MyViewHolder(private val binding: ItemSectionBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(sectionModel: SectionModel) {
            binding.txtCategory.text = sectionModel.category
            binding.txtTotal.text = "${sectionModel.friendList.size}명"
            binding.rvSubFriend.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(binding.root.context)
                adapter = FriendSubAdapter(sectionModel.friendList)
                addItemDecoration(DividerItemDecoration(binding.root.context, DividerItemDecoration.VERTICAL))
            }
        }

    }

}