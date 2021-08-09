package com.example.moneysaver.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import com.example.moneysaver.R
import com.example.moneysaver.ui.clientlist.SignUpActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        automaticPAssage()
    }

    fun automaticPAssage(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }
        else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        @Suppress("DEPRECATION")

        Handler().postDelayed(
            {
                startActivity(Intent(this, SignUpActivity::class.java))
                finish()

            }  ,3000
        )
    }

}