package com.example.moneysaver.ui.HistoryFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.data.db.entities.ExpenseModelClass
import com.example.moneysaver.data.room_repostories.ExpenseRepository
import com.example.moneysaver.databinding.FragmentHistoryBinding
import com.example.moneysaver.databinding.ItemsBinding
import com.example.moneysaver.utils.CustomAlertDialog
import com.example.moneysaver.utils.DeleteItemDialog
import com.example.moneysaver.utils.ExpenseAdapter

class HistoryFragment : Fragment(),ExpenseAdapter.OnExpenseItemClickListener {
    private  lateinit var binding: FragmentHistoryBinding
    private  lateinit var adapter :ExpenseAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list= mutableListOf<ExpenseModelClass>()
        val database = MoneySaverDatabase(requireContext())
        val repository = ExpenseRepository(database)
        val factory = HistoryFragmentViewFactory(repository,requireContext())
        val provider = ViewModelProvider(this, factory)
        val viewModel = provider.get(HistoryFragmentViewModel::class.java)
         adapter = ExpenseAdapter(list, this,viewModel)
        binding.rvExpensesItems.layoutManager=LinearLayoutManager(requireContext())
        binding.rvExpensesItems.adapter=adapter

        viewModel.getCurrentUserExpenses(viewModel.getId()).observe(viewLifecycleOwner,{
            adapter.dataSEt=it
            adapter.notifyDataSetChanged()
           val itemsBinding:ItemsBinding= ItemsBinding.inflate(layoutInflater)

            adapter.ExpenseViewHolder(itemsBinding).onClick(itemsBinding.root)



        })





    }

    override fun expenseOnItemClick(position: Int,viewModel:HistoryFragmentViewModel) {

        DeleteItemDialog(viewModel).showAlertDialog(requireActivity(),adapter.dataSEt[position].id!!)

    }
}
