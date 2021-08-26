package com.example.moneysaver.ui.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.moneysaver.R
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.data.db.entities.ExpenseModelClass
import com.example.moneysaver.data.room_repostories.ExpenseRepository
import com.example.moneysaver.databinding.FragmentMainBinding
import com.example.moneysaver.utils.CustomAlertDialog
import com.example.moneysaver.utils.CustomDataStore
import kotlinx.coroutines.*

class MainFragment : Fragment() {
    private lateinit var dataStore: CustomDataStore
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
        val factory = MainFragmentViewModelFactory(repository)
        val provider = ViewModelProvider(this, factory)
        val viewModel = provider.get(MainFragmentViewModel::class.java)

        dataStore = CustomDataStore(requireContext())
         this.lifecycleScope.launch(Dispatchers.Main) {
             val  userId=dataStore.readInt(getString(R.string.id))!!
             binding.expensesPerMonth.setOnClickListener {
                 val alertDialog = CustomAlertDialog(requireContext())

                 alertDialog.showCustomAlertDialog(viewModel,
                     ExpenseModelClass(clientId = userId),
                     getString(R.string.expenses_details),
                     getString(R.string.title),
                     getString(R.string.price)
                 )

             }

         }





             }


             }








