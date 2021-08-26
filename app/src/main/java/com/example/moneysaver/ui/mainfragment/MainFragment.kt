package com.example.moneysaver.ui.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.moneysaver.R
import com.example.moneysaver.databinding.FragmentMainBinding
import com.example.moneysaver.utils.Constants
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
        dataStore = CustomDataStore(requireContext())
        val alertDialog = CustomAlertDialog(requireContext())

                              binding.expensesPerMonth.setOnClickListener {
                          alertDialog.showCustomAlertDialog(
                              getString(R.string.expenses_details),
                              getString(R.string.title),
                              getString(R.string.price)
                          )
                      }




             }


             }








