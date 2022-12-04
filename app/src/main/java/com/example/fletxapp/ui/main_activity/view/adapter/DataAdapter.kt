package com.example.fletxapp.ui.main_activity.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fletxapp.databinding.RowItemBinding
import com.example.fletxapp.domain.Model

class DataAdapter (private val viewHolderListener: DataViewHolder.ViewHolderListener): RecyclerView.Adapter<DataViewHolder>() {

    private var modelList = mutableListOf<Model>()
    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemBinding = RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        this.context = parent.context
        return DataViewHolder(itemBinding, viewHolderListener)
    }

    override fun getItemCount() = modelList.size


    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(modelList[position], context)
    }

    fun setList(modelList: List<Model>) {
        this.modelList.clear()
        this.modelList = modelList.toMutableList()
        notifyDataSetChanged()
    }

    fun isEmpty(): Boolean {
        return modelList.isEmpty()
    }
}