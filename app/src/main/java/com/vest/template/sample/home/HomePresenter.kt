package com.vest.template.sample.home

import com.vivek.wo.mvp.basemvp.BasePresenter
import org.jsoup.Jsoup

val BASE_HTML = "https://kaijiang.500.com/ssq.shtml"

class HomePresenter : BasePresenter<HomeView> {
    var homeView: HomeView? = null

    fun getData() {
        Thread {
            var document = Jsoup.connect(BASE_HTML).get()
            val element = document.select("table.kj_tablelist02").first()

            val elsIssueNumber = element.select("td.td_title01")
            val issueNumber: String = elsIssueNumber.select("strong").text()
            val issueNumberDate: String = elsIssueNumber.select("span.span_right").text()
            homeView?.updateLottery(issueNumber, issueNumberDate)

            val elementLotteryNumbers = element.select("div.ball_box01").select("li")
            val lotteryNumberArray = arrayOfNulls<String>(7)
            for ((index, element) in elementLotteryNumbers.withIndex()) {
                lotteryNumberArray[index] = element.text()
            }
            homeView?.updateLotteryNumber(lotteryNumberArray)
        }.start()
    }

    override fun takeView(view: HomeView?) {
        homeView = view
    }

    override fun dropView() {
        homeView = null
    }
}