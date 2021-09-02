package com.example.moneysaver.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.moneysaver.databinding.ActivitySplashBinding
import android.view.WindowInsets
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.moneysaver.R
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.utils.Constants
import com.example.moneysaver.ui.mainActivity.MainActivity
import com.example.moneysaver.ui.signIn.SignInActivity
import com.example.moneysaver.ui.signIn.SignInViewModel
import com.example.moneysaver.ui.signIn.SignInViewModelFactory
import com.example.moneysaver.ui.splashActivity.SplashActivityViewModel
import com.example.moneysaver.ui.splashActivity.SplashActivtyViewModelFactory
import com.example.moneysaver.utils.CustomDataStore
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = SplashActivtyViewModelFactory(this)
        val provider = ViewModelProvider(this, factory)
        val viewModel = provider.get(SplashActivityViewModel::class.java)
        val b=viewModel.getId()

        viewModel.automaticPAss(this,binding)
    }





}


