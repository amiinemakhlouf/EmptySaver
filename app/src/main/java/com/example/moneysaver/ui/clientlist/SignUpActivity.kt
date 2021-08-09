package com.example.moneysaver.ui.clientlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.moneysaver.R
import com.example.moneysaver.data.db.MoneySAverDatabase
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.databinding.ActivitySignUpBinding
import com.example.moneysaver.repostories.MoneySaverMoneySaverRepository

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivitySignUpBinding.inflate(layoutInflater)
       setContentView(binding.root)

        val database=MoneySAverDatabase(this)
        val repository=MoneySaverMoneySaverRepository(database)
        val factory=ClientViewModelFactory(repository )
        val provider : ViewModelProvider = ViewModelProvider(this,factory)
        val viewModel = provider.get(ClientViewModel::class.java)
        binding.btSignUp.setOnClickListener {
            if(isBlanck(binding.etPAssword)||isBlanck(binding.etSalary)||isBlanck(binding.etUsername)||isBlanck(binding.etExpenseLimit))
                Toast.makeText(this," please enter all your information ",Toast.LENGTH_SHORT).show()
            else{
                val username=binding.etUsername
                val password=binding.etPAssword
                val salary=binding.etPAssword
                val ExpenseLimit=binding.etExpenseLimit
                val client= ClientModelClass(username = username.text.toString(),password =password.text.toString(),
                    salary=salary.text.toString().toDouble() ,ExpenseLimit.text.toString().toDouble())
                viewModel.upsert(client)

            }
        }

    }
    fun isBlanck(editText: EditText):Boolean=editText.text.isBlank()





}

}