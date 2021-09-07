package com.example.moneysaver.utils

import android.renderscript.ScriptGroup
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.moneysaver.R
import com.example.moneysaver.data.db.entities.ExpenseModelClass
import com.example.moneysaver.databinding.FragmentHistoryBinding
import com.example.moneysaver.databinding.ItemsBinding
import com.example.moneysaver.ui.HistoryFragment.HistoryFragment
import com.example.moneysaver.ui.HistoryFragment.HistoryFragmentViewModel

class ExpenseAdapter(
    var dataSEt: MutableList<ExpenseModelClass>, val listener:HistoryFragment,val viewModel:HistoryFragmentViewModel
) : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {
    inner class ExpenseViewHolder(val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root),View.OnClickListener{
           init {
               binding.tvTitle.setOnClickListener(this)
           }

        override fun onClick(v: View?) {
            val position =adapterPosition
            if(position!=RecyclerView.NO_POSITION)
               listener.expenseOnItemClick(position,viewModel )
        }



    }
    interface OnExpenseItemClickListener{
        fun expenseOnItemClick(position:Int,viewModel:HistoryFragmentViewModel)
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {


        return ExpenseViewHolder(
            ItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val p = dataSEt[position]
        holder.itemView.apply {
            holder.binding.tvPrice.text = p.expenseValue.toString()
            holder.binding.tvTitle.text = p.title
            holder.binding.tvCategory.text = p.category
            when (p.category) {
                resources.getString(R.string.daily) -> holder.binding.tvCategory.setTextColor(
                    resources.getColor(R.color.green, null)
                )
                resources.getString(R.string.monthly) -> holder.binding.tvCategory.setTextColor(
                    resources.getColor(R.color.red, null)
                )
                resources.getString(R.string.weekly) -> holder.binding.tvCategory.setTextColor(
                    resources.getColor(R.color.blue, null)
                )
                resources.getString(R.string.various_pascal_case) -> holder.binding.tvCategory.setTextColor(
                    resources.getColor(R.color.pink, null)
                )


            }
            /*    holder.binding.root.setOnClickListener {
                    Log.d("mon teste","fonctionne bien")
                }*/
        }
    }


    override fun getItemCount(): Int {
        return dataSEt.size
    }

}