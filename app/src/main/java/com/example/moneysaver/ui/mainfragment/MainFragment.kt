package com.example.moneysaver.ui.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.moneysaver.R
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.data.room_repostories.ExpenseRepository
import com.example.moneysaver.databinding.FragmentMainBinding
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.utils.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.NullPointerException

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = MoneySaverDatabase(requireContext())
        val repository = ExpenseRepository(database)
        val rep = ClientRepository(database)
        val factory = MainFragmentViewModelFactory(repository, rep, requireContext())
        val provider = ViewModelProvider(this, factory)
        val viewModel = provider.get(MainFragmentViewModel::class.java)

        categoryOnClickListener(binding.expensesPerDay,viewModel,Category.Daily.coeff,Category.Daily.name)
        categoryOnClickListener(binding.expensesPerMonth,viewModel,Category.Monthly.coeff,Category.Monthly.name)
        categoryOnClickListener(binding.expensesPerWeek,viewModel,Category.Weekly.coeff,Category.Weekly.name)
        categoryOnClickListener(binding.variousExpenses,viewModel,Category.Various.coeff,Category.Various.name)
        showRemainingMoney(
            viewModel.getSalary(viewModel.getId()),
            viewModel.getSumExpenses(viewModel.getId()),
            viewModel.getSalaryLimit(viewModel.getId()),
            binding.RemainingMoney
        )


    }

    private fun showRemainingMoney(
        salaryliveData: LiveData<Double>,
        expensesLiveData: LiveData<Double>,
        salaryLimit: LiveData<Double>,
        textView: TextView
    ) {
        salaryliveData.observe(viewLifecycleOwner, { it ->
            val salary = it

            expensesLiveData.observe(viewLifecycleOwner, {
                var expenses: Double
                try {
                    expenses = it

                } catch (error: NullPointerException) {
                    expenses = 0.0

                }
                val remainingMoney = salary - expenses
                //

                salaryLimit.observe(viewLifecycleOwner, {
                    val limitSalary = it
                    if (remainingMoney <= limitSalary)
                        textView.setTextColor(resources.getColor(R.color.red, null))
                    else
                        textView.setTextColor(resources.getColor(R.color.green, null))


                    textView.setText(remainingMoney.toString())

                })

            })

        }
        )


    }
    fun categoryOnClickListener(view:View,viewModel:MainFragmentViewModel,coef:Int,name:String){
        this.lifecycleScope.launch(Dispatchers.Main) {
            view.setOnClickListener {
                viewModel.alertDialog()

                viewModel.alertDialog().showCustomAlertDialog(
                    viewModel.getId(),
                    viewModel,
                     coef        ,
                    name,
                    getString(R.string.expenses),
                    getString(R.string.title),
                    getString(R.string.price)
                )

            }


        }



    }





}








