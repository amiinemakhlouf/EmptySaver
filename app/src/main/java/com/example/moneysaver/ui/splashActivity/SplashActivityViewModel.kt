package com.example.moneysaver.ui.splashActivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.moneysaver.R
import com.example.moneysaver.databinding.ActivitySplashBinding
import com.example.moneysaver.ui.mainActivity.MainActivity
import com.example.moneysaver.ui.signIn.SignInActivity
import com.example.moneysaver.utils.Constants
import com.example.moneysaver.utils.CustomDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class SplashActivityViewModel @Inject constructor() : ViewModel() {

    fun getId(context: Context): Int {
        var id: Int = -1
        runBlocking {
            if (CustomDataStore(context).readInt(context.getString(R.string.id)) != null)
                id = CustomDataStore(context).readInt(context.getString(R.string.id))!!

        }
        return id

    }

    fun goToMainActivity(context: Context) {
        context.startActivity(Intent(context, MainActivity::class.java))

    }

    fun goToSignInActivity(context: Context) {
        context.startActivity(Intent(context, SignInActivity::class.java))
    }

    fun hideSystemUI(binding: ActivitySplashBinding,context: Activity) {
        WindowCompat.setDecorFitsSystemWindows(context.window, false)
        WindowInsetsControllerCompat(context.window, binding.root).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    fun automaticPAss(context: Activity, binding: ActivitySplashBinding) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            context.window.insetsController?.hide(WindowInsets.Type.statusBars())
        }
        hideSystemUI(binding,context)



        Handler(Looper.getMainLooper()).postDelayed({
            viewModelScope.launch {

                if (userConnected(this@SplashActivityViewModel.getId(context))) {
                    this@SplashActivityViewModel.goToMainActivity(context)
                } else {
                    this@SplashActivityViewModel.goToSignInActivity(context)
                }

            }


        }, Constants.DELAY_MILLIS)

    }

    fun userConnected(id: Int?) = (id != -1)


}