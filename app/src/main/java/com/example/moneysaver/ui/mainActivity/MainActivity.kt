package com.example.moneysaver.ui.mainActivity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.moneysaver.Constants
import com.example.moneysaver.Constants.ID
import com.example.moneysaver.ui.ProfileFragment.ProfileFragment
import com.example.moneysaver.R
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.databinding.ActivityMainBinding
import com.example.moneysaver.repostories.MoneySaverRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataStore: DataStore<Preferences>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        binding.topToolbar.setNavigationOnClickListener { showAlertDialog() }
        val id = intent.getIntExtra(Constants.ID, -1) // current user id
        Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show()
        val database = MoneySaverDatabase(this)
        val repository = MoneySaverRepository(database)
        val factory = MainActivityViewModelFactory(repository)
        val provider = ViewModelProvider(this, factory)
        val viewModel = provider.get(MainActivityViewModel::class.java)
        val client = viewModel.getCurrentUserData(id)
        dataStore = createDataStore(R.string.settings.toString())
        lifecycleScope.launch {
            saveInt(Constants.ID, id)

        }



        supportFragmentManager.beginTransaction().apply {
            replace(R.id.ffFragment, ProfileFragment()).commit()


        }

        mOnNavigationItemSelectedListener()


    }



    private suspend fun saveInt(key: String, value: Int) {
        val dataStoreKey = preferencesKey<Int>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }
    private suspend fun saveDouble(key: String, value: Double) {
        val dataStoreKey = preferencesKey<Double>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }
    private suspend fun saveString(key: String, value: String) {
        val dataStoreKey = preferencesKey<String>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }





    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.Android_Alert)
        builder.setMessage(R.string.sign_out_question)

        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            lifecycleScope.launch {
                saveInt(ID, -1)

            }

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
            }
        }

        false
    }
}