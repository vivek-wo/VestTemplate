package com.vest.template

import android.app.Application
import cn.jpush.android.api.JPushInterface

class VestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)
    }

}