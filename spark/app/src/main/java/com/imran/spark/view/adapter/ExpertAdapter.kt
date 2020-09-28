package com.imran.spark.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.imran.spark.R
import com.imran.spark.databinding.ExpertListBinding
import com.imran.spark.model.Expert

/**
 * Created by imran on 2020-09-28.
 */
class ExpertAdapter(
    private var mList: List<Expert>,
) : RecyclerView.Adapter<ExpertAdapter.AdapterViewHolder>() {
    private var binding: ExpertListBinding? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.expert_list_item,
            parent,
            false
        )
        return AdapterViewHolder(binding!!)
    }

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val message = mList[position]
        holder.bindData(message)
    }

    class AdapterViewHolder(private var binding: ExpertListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(expert: Expert) = binding.apply {
            mExpert = expert
            executePendingBindings()
        }
    }
}
