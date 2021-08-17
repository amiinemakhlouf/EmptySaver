package com.example.moneysaver.activities


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.moneysaver.ProfileFragment
import com.example.moneysaver.R
import com.example.moneysaver.databinding.ActivityMainBinding
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
        val id=intent.getIntExtra("id",888)
        //Log.d("id value",id.toString())
        Toast.makeText(this,id.toString(),Toast.LENGTH_SHORT).show()
        val sharedPref=getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor=sharedPref.edit()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.ffFragment,ProfileFragment()).commit()


        }

        mOnNavigationItemSelectedListener()


    }



    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.Android_Alert)
        builder.setMessage(R.string.sign_out_question)

        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            finishAffinity()


        }

        builder.setNegativeButton(android.R.string.cancel) { _, _ ->
            finish()

        }


        builder.show()
    }
     private fun mOnNavigationItemSelectedListener() = binding.navBar.setOnItemSelectedListener {

        when (it.itemId) {
            R.id.profileItem -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.ffFragment, ProfileFragment()).commit()

                }
                return@setOnItemSelectedListener true
            }
            R.id.addItem -> {
                //   do stuff

                return@setOnItemSelectedListener true
            }}

            false
    }}