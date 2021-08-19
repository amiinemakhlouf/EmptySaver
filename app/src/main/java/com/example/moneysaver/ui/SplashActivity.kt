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
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import com.example.moneysaver.Constants
import com.example.moneysaver.R
import com.example.moneysaver.ui.mainActivity.MainActivity
import com.example.moneysaver.ui.signIn.SignInActivity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private  lateinit var dataStore:DataStore<Preferences>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataStore=createDataStore(R.string.settings.toString())
        automaticPAss()
    }

    private fun automaticPAss(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }
        hideSystemUI()


        Handler(Looper.getMainLooper()).postDelayed({
            lifecycleScope.launch {
                val id=    read(Constants.ID)
                if(userConnected(id))
                {
                    intent= Intent(this@SplashActivity, MainActivity::class.java)
                    intent.putExtra(Constants.ID,id)
                    startActivity(intent)

                }
                   else
                {
                    intent= Intent(this@SplashActivity, SignInActivity::class.java)
                    startActivity(intent)

                }

            }



        }, Constants.DELAY_MILLIS)

    }
    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, binding.root).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

fun userConnected(id:Int?)=(id!=-1)
    private suspend fun read(key: String): Int? {
        val dataStoreKey = preferencesKey<Int>(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }


}


