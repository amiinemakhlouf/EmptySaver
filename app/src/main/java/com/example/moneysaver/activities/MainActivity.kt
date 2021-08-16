package com.example.moneysaver.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.viewbinding.ViewBinding
import com.example.moneysaver.ProfileFragment
import com.example.moneysaver.R
import com.example.moneysaver.databinding.ActivityMainBinding
import com.example.moneysaver.databinding.ActivitySignUpBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        binding.topToolbar.setNavigationOnClickListener { showAlertDialog() }
        val id=intent.getStringExtra("id")


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.ffFragment,ProfileFragment()).commit()


        }

        mOnNavigationItemSelectedListener


    }



    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Android Alert")
        builder.setMessage("do you want to sign out")

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            finishAffinity()


        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            finish()

        }


        builder.show()
    }
    val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.profileItem-> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.ffFragment,ProfileFragment()).commit()

                }
                return@OnNavigationItemSelectedListener true
            }





        }
        false
    }

}