package com.example.moneysaver.ui.signUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.moneysaver.utils.Constants
import com.example.moneysaver.utils.Constants.PASSWORD_MISMATCH_MSG_ERROR
import com.example.moneysaver.utils.Constants.SALARY_MSG_ERROR
import com.example.moneysaver.R
import com.example.moneysaver.ui.mainActivity.MainActivity
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.databinding.ActivitySignUpBinding
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.utils.CheckInputs
import com.example.moneysaver.utils.CustomDataStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var checkInputs: CheckInputs
    private lateinit var customDataStore: CustomDataStore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        customDataStore = CustomDataStore(this)
        val database = MoneySaverDatabase(this)
        val repository = ClientRepository(database)
        val viewModel = ViewModelProvider(this).get(SignUpViewModel(repository)::class.java)
        checkInputs = CheckInputs()
        binding.btSignUp.setOnClickListener {
            val etUsername: EditText = binding.etUsername
            val etPassword: EditText = binding.etPAssword
            val etConfirmPassword: EditText = binding.etConfirmPassword
            val etSalary: EditText = binding.etSalary
            val etExpenseLimit: EditText = binding.etExpenseLimit

            if (inputsAreBlanks())

                Toast.makeText(this, R.string.get_information, Toast.LENGTH_SHORT)
                    .show()
            else {

                if (!(checkInputs.passwordIsValid(etPassword))) {
                    etPassword.error =getString(R.string.password_msg_error)



                } else {
                    if (!(checkInputs.isMatch(password = etPassword, etConfirmPassword))) {
                        etConfirmPassword.error =
                            getString(R.string.password_mismatch_error)
                    } else {
                        if (etExpenseLimit.text.toString()
                                .toDouble() > etSalary.text.toString().toDouble()
                        )

                            etExpenseLimit.error = getString(R.string.salary_msg_error)
                        else {

                            val client = ClientModelClass(
                                username = etUsername.text.toString(),
                                password = etPassword.text.toString(),
                                salary = etSalary.text.toString().toDouble(),
                                etExpenseLimit.text.toString().toDouble()
                            )
                            viewModel.upsert(client)
                            Toast.makeText(
                                this,
                                R.string.account_created_successfully,
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            intent = Intent(this, MainActivity::class.java)

                              lifecycleScope.launch {
                                  delay(Constants.DELAY_MILLIS)
                                viewModel.checkClient(
                                    username = etUsername.text.toString(),
                                    etPassword.text.toString()
                                )
                                    .observe(this@SignUpActivity, {
                                        if (it == null) {
                                            Toast.makeText(
                                                this@SignUpActivity,
                                                R.string.authentification_not_valid,
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        } else {
                                            lifecycleScope.launch {
                                                getString(R.string.id)
                                                customDataStore.saveInt(getString(R.string.id), it.id!!)
                                                startActivity(intent)
                                            }

                                        }

                                    }) }
                    }
                }
            }
        }

    }
    }



    fun inputsAreBlanks(): Boolean =
        (checkInputs.isBlanck(binding.etPAssword) || checkInputs.isBlanck(binding.etSalary) || checkInputs.isBlanck(
            binding.etUsername
        ) ||
                checkInputs.isBlanck(binding.etExpenseLimit)
                )


}

