package com.example.moneysaver.ui.clientlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.moneysaver.data.db.MoneySAverDatabase
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.databinding.ActivitySignUpBinding
import com.example.moneysaver.repostories.MoneySaverRepository

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivitySignUpBinding.inflate(layoutInflater)
       setContentView(binding.root)

        val database=MoneySAverDatabase(this)
        val repository=MoneySaverRepository(database)
        val factory=ClientViewModelFactory(repository )
        val provider : ViewModelProvider = ViewModelProvider(this,factory)
        val viewModel = provider.get(ClientViewModel::class.java)
        binding.btSignUp.setOnClickListener {
            if(isBlanck(binding.etPAssword)||isBlanck(binding.etSalary)||isBlanck(binding.etUsername)||
                    isBlanck(binding.etExpenseLimit))
                Toast.makeText(this," please enter all your information ",Toast.LENGTH_SHORT).show()
            else{
                  if(!(passwordIsValid(binding.etPAssword)))
                  {
                      binding.etPAssword.error="password must contain letters , digits and at least 8 characters"
                     // binding.etPAssword.text!!.clear()

                  }
                  else{
                          if (binding.etExpenseLimit.text.toString().toDouble()>binding.etSalary.text.toString().toDouble())

                              binding.etExpenseLimit.error=  "salary limit cannot be higher than salary "
                          else {
                val username=binding.etUsername
                val password=binding.etPAssword
                val salary=binding.etSalary
                val ExpenseLimit=binding.etExpenseLimit
                val client= ClientModelClass(username = username.text.toString(),password =password.text.toString(),
                    salary=salary.text.toString().toDouble() ,ExpenseLimit.text.toString().toDouble())
                viewModel.upsert(client)
                Toast.makeText(this," account created successfully",Toast.LENGTH_SHORT).show()

            } }
        }}

    }
    fun passwordIsValid(editText: EditText):Boolean{

        // password must contain letters , numbers and at least 8 characters
        val hasDigits:Boolean = editText.text.toString().any { it.isDigit() }
        val hasLetters:Boolean=editText.text.toString().any { it.isLetter() }


        return(hasDigits && hasLetters &&editText.text.toString().length>=8)



    }

    fun isBlanck(editText: EditText):Boolean=editText.text.isBlank()





}

