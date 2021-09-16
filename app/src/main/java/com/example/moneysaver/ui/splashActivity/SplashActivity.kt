package com.example.moneysaver.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moneysaver.databinding.ActivitySplashBinding
import androidx.activity.viewModels
import com.example.moneysaver.ui.splashActivity.SplashActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private  val viewModel:SplashActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.automaticPAss(this,binding)
    }





}


