package com.vest.template

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View

//TODO 背景图片设置在Theme中，存在内存占用问题
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fitHideNavigation()
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, GuideActivity::class.java))
            finish()
        }, 3 * 1000)
    }

    private fun fitHideNavigation() {
        val decorView = window.decorView
        val options = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN)
        decorView.systemUiVisibility = options
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
