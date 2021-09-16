package com.example.moneysaver.ui.HistoryFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneysaver.R
import com.example.moneysaver.data.db.entities.ExpenseModelClass
import com.example.moneysaver.databinding.FragmentHistoryBinding
import com.example.moneysaver.databinding.ItemsBinding
import com.example.moneysaver.utils.DeleteItemDialog
import com.example.moneysaver.utils.ExpenseAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment(),ExpenseAdapter.OnExpenseItemClickListener {
    private  lateinit var binding: FragmentHistoryBinding
    private  lateinit var expenseAdapter :ExpenseAdapter

    private  val viewModel:HistoryFragmentViewModel by viewModels()

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
        val dataSet= mutableListOf<ExpenseModelClass>()
        initRecyclerView(dataSet,this,viewModel)


        viewModel.getCurrentUserExpenses(viewModel.getId(requireContext())).observe(viewLifecycleOwner,{
            expenseAdapter.dataSEt=it
            expenseAdapter.notifyDataSetChanged()
           val itemsBinding:ItemsBinding= ItemsBinding.inflate(layoutInflater)

            expenseAdapter.ExpenseViewHolder(itemsBinding).onClick(itemsBinding.root)



        })
        binding.spinnerFilter.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(parent?.getItemAtPosition(position).toString()){
                    getString(R.string.price) ->
                        viewModel.filterByPrice(viewModel.getId(requireContext())).observe(viewLifecycleOwner,{
                            expenseAdapter.dataSEt=it
                            expenseAdapter.notifyDataSetChanged()


                        })
                       getString(R.string.category)
                       ->
                           viewModel.filterByPrice(viewModel.getId(requireContext())).observe(viewLifecycleOwner,{
                               expenseAdapter.dataSEt=it
                               expenseAdapter.notifyDataSetChanged()


                           })

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }





    }

    override fun expenseOnItemClick(position: Int,viewModel:HistoryFragmentViewModel) {

        DeleteItemDialog(viewModel).showAlertDialog(requireActivity(),expenseAdapter.dataSEt[position].id!!)

    }
    private fun initRecyclerView(dataset:MutableList<ExpenseModelClass>,listener:HistoryFragment,viewModel: HistoryFragmentViewModel){

        binding.rvExpensesItems.apply {
            layoutManager = LinearLayoutManager(requireContext())
            expenseAdapter = ExpenseAdapter(dataset,listener,viewModel)
            adapter = expenseAdapter
        }
    }

}
