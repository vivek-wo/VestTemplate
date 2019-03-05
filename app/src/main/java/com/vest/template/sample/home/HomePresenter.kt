package com.vest.template.sample.home

import android.util.Log
import com.vivek.wo.mvp.basemvp.BasePresenter
import org.jsoup.Jsoup

val BASE_HTML = "https://kaijiang.500.com/ssq.shtml"

class HomePresenter : BasePresenter<HomeView> {
    var homeView: HomeView? = null

    fun getData() {
        Thread {
            var document = Jsoup.connect(BASE_HTML).get()
            val elements = document.select("table.kj_tablelist02")
            val elsIssueNumber = elements.select("td.td_title01")
            val issueNumber: String = elsIssueNumber.select("strong").text()
            val issueNumberDate: String = elsIssueNumber.select("span.span_right").text()

            Log.e("----", "双色球第${issueNumber}期,$issueNumberDate")
        }.start()
    }

    override fun takeView(view: HomeView?) {
        homeView = view
    }

    override fun dropView() {
        homeView = null
    }
}