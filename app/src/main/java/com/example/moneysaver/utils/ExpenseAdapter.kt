package com.example.moneysaver.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneysaver.R
import com.example.moneysaver.data.db.entities.ExpenseModelClass
import com.example.moneysaver.databinding.FragmentHistoryBinding
import com.example.moneysaver.databinding.ItemsBinding

class ExpenseAdapter (var  dataSEt:List<ExpenseModelClass>,binding: FragmentHistoryBinding
): RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> ()  {
    class ExpenseViewHolder( val binding:ItemsBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        return ExpenseViewHolder(ItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }
    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val  p=dataSEt[position]
        holder.itemView.apply {
            holder.binding.tvPrice.text=p.expenseValue.toString()
            holder.binding.tvTitle.text=p.title
        }
        }



    override fun getItemCount(): Int {
        return dataSEt.size
    }}