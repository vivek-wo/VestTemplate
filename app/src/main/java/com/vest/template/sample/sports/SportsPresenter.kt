package com.vest.template.sample.sports

import com.vivek.wo.mvp.basemvp.BasePresenter
import org.jsoup.Jsoup
import java.io.IOException


class SportsPresenter : BasePresenter<SportsView> {

    var sportsView: SportsView? = null

    fun getData(htmlUrl: String) {
        Thread {
            try {
                var document = Jsoup.connect(htmlUrl).get()

                val elements = document.select("table.kj_tablelist02")

                val elsIssueNumber = elements.select("td.td_title01")
                val issueNumber: String = elsIssueNumber.select("strong").text()
                val issueNumberDate: String = elsIssueNumber.select("span.span_right").text()
                sportsView?.updateLottery(issueNumber, issueNumberDate)

                val elementLotteryNumbers = elements.select("div.ball_box01").select("li")
                val lotteryNumberArray = arrayOfNulls<String>(7)
                for ((index, element) in elementLotteryNumbers.withIndex()) {
                    lotteryNumberArray[index] = element.text()
                }
                sportsView?.updateLotteryNumber(lotteryNumberArray)

                val previousIssueNumber = document.select("a.iSelect").first().text().toInt() - 1
                var previousIssueText = "超级大乐透${previousIssueNumber}开奖结果"
                var previousIssueUrl = "http://kaijiang.500.com/shtml/dlt/${previousIssueNumber}.shtml"
                sportsView?.updatePreviousIssue(previousIssueText, previousIssueUrl)
            } catch (exception: IOException) {
                exception.printStackTrace()
            }
        }.start()
    }

    override fun takeView(view: SportsView?) {
        sportsView = view
    }

    override fun dropView() {
        sportsView = null
    }
}