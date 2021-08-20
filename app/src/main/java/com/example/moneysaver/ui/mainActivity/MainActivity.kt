package com.example.moneysaver.ui.mainActivity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.moneysaver.utils.Constants.ID
import com.example.moneysaver.ui.ProfileFragment.ProfileFragment
import com.example.moneysaver.R
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.databinding.ActivityMainBinding
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.utils.CustomAlertDialog
import com.example.moneysaver.utils.CustomDataStore
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataStore: DataStore<Preferences>
    private lateinit var customAlertDialog: CustomAlertDialog
    private lateinit var customDataStore: CustomDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topToolbar)
        customAlertDialog = CustomAlertDialog()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        customDataStore = CustomDataStore(this)
        binding.topToolbar.setNavigationOnClickListener {
            customAlertDialog.showAlertDialog(this, customDataStore)
        }

        dataStore = createDataStore(R.string.settings.toString())



        supportFragmentManager.beginTransaction().apply {
            replace(R.id.ffFragment, ProfileFragment()).commit()


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
                //   do stuff

                return@setOnItemSelectedListener true
            }
        }

        false
    }
}