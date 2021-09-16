package com.example.moneysaver.ui.ProfileFragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.example.moneysaver.utils.Constants
import com.example.moneysaver.R
import com.example.moneysaver.data.db.ExpensesDao
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.databinding.FragmentProfileBinding
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.ui.signIn.SignInActivity
import com.example.moneysaver.utils.CustomDataStore
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.NullPointerException

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private lateinit var dataStore: CustomDataStore
    private lateinit var binding:FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataStore= CustomDataStore(requireContext())

        lifecycleScope.launch {
            val id1 = dataStore.readInt(getString(R.string.id))
            try{
                viewModel.getCurrentUserData(id1!!)
                    .observe(viewLifecycleOwner, {
                        binding.etUersname.setText(it.username)
                        binding.etSalary1.setText(it.salary.toString())
                        binding.etLimitSalary.setText(it.expenseLimit.toString())



                    })
            } catch(exception:NullPointerException)
            {
                 val intent= Intent(requireActivity(),SignInActivity::class.java)
                 startActivity(intent)

            }

        }
            binding.updateButton.setOnClickListener {
                lifecycleScope.launch {
                    val id1=dataStore.readInt(getString(R.string.id))
                    val username=binding.etUersname.text.toString()
                    val salary=binding.etSalary1.text.toString().toDouble()
                    val salaryLimit=binding.etLimitSalary.text.toString().toDouble()
                    if(salaryLimit>salary)
                        binding.etLimitSalary.error=getString(R.string.salary_msg_error)
                    else {

                        val client = ClientModelClass(username, "monastir", salary, salaryLimit)
                        client.id = id1
                        viewModel.upsert(client)
                        Toast.makeText(
                            requireContext(),
                            R.string.account_updated_successfully,
                            Toast.LENGTH_SHORT
                        ).show()

                    }
            }}












    }


}