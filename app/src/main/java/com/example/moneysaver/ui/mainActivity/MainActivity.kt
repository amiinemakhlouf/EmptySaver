package com.example.moneysaver.ui.mainActivity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import com.example.moneysaver.ui.ProfileFragment.ProfileFragment
import com.example.moneysaver.R
import com.example.moneysaver.databinding.ActivityMainBinding
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.ui.HistoryFragment.HistoryFragment
import com.example.moneysaver.ui.mainfragment.MainFragment
import com.example.moneysaver.utils.LogOutAlertDialog
import com.example.moneysaver.utils.CustomDataStore
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var logOutAlertDialog: LogOutAlertDialog
    private lateinit var customDataStore: CustomDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topToolbar)
        logOutAlertDialog = LogOutAlertDialog()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        customDataStore = CustomDataStore(this)
        binding.topToolbar.setNavigationOnClickListener {
            logOutAlertDialog.showAlertDialog(this, customDataStore)
        }




        supportFragmentManager.beginTransaction().apply {
            replace(R.id.ffFragment, MainFragment()).commit()


        }

        mOnNavigationItemSelectedListener()


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
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.ffFragment, MainFragment()).commit()

                }


                return@setOnItemSelectedListener true
            }
            R.id.historyItem-> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.ffFragment, HistoryFragment()).commit()

                }
                return@setOnItemSelectedListener true
            }
        }

        false
    }
}