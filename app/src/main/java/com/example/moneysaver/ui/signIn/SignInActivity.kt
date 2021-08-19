package com.example.moneysaver.ui.signIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.moneysaver.Constants
import com.example.moneysaver.R
import com.example.moneysaver.ui.mainActivity.MainActivity
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.databinding.ActivitySignInBinding
import com.example.moneysaver.repostories.MoneySaverRepository
import com.example.moneysaver.ui.signUp.SignUpActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvSignUp.setOnClickListener {
            intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        val database = MoneySaverDatabase(this)
        val repository = MoneySaverRepository(database)
        val factory = SignInViewModelFactory(repository)
        val provider = ViewModelProvider(this, factory)
        val viewModel = provider.get(SignInViewModel::class.java)

        binding.btSignIn.setOnClickListener {

            val username = binding.etUsername.text.toString()
            val password = binding.etPAssword.text.toString()
            viewModel.checkClient(username = username, password = password)
                .observe(this, {

                    if (it == null) {
                        Toast.makeText(
                            this,
                            R.string.authentification_not_valid,
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {
                        intent = Intent(this, MainActivity::class.java)
                        intent.putExtra(Constants.ID, it.id)
                        startActivity(intent)

                    }

                })

        }
    }
}