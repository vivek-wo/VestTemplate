package com.vest.template.sample.zodiac

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vivek.wo.mvp.basemvp.BasePresenter


class ZodiacPresenter(val context: Context) : BasePresenter<ZodiacView> {

    var zodiacView: ZodiacView? = null

    init {
    }

    fun getData() {
        Thread {
            var inputStream = context.assets.open("zodiac")
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val turnsType = object : TypeToken<List<ZodiacData>>() {}.type
            val zodiacDataList = Gson().fromJson<List<ZodiacData>>(jsonString, turnsType)
            zodiacView?.updateZodiacData(zodiacDataList)
        }.start()
    }

    override fun takeView(view: ZodiacView?) {
        zodiacView = view
    }

    override fun dropView() {
        zodiacView = null
    }
}