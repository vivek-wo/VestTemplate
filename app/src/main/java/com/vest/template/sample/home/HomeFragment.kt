package com.vest.template.sample.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.vest.template.sample.MainPresenter
import com.vest.template.sample.R
import kotlinx.android.synthetic.main.fragment_home.*

val BASE_HTML = "https://kaijiang.500.com/ssq.shtml"

class HomeFragment : Fragment(), HomeView {
    lateinit var homePresenter: HomePresenter
    override fun setPresenter(presenter: MainPresenter?) {
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, null)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homePresenter = HomePresenter()
        homePresenter.takeView(this)
        homePresenter.getData(BASE_HTML)
    }

    override fun updateLottery(issueNumber: String, issueNumberDate: String) {
        activity?.runOnUiThread {
            var issueNumberString = "双色球第 <font color='#FF0000'>$issueNumber</font> 期"
            lotteryTypeText.text = Html.fromHtml(issueNumberString)
            lotteryTypeDateText.text = issueNumberDate
        }
    }

    override fun updateLotteryNumber(lotteryNumberArray: Array<String?>) {
        activity?.runOnUiThread {
            lotteryNumberLayout.removeAllViews()
            for ((index, number) in lotteryNumberArray.withIndex()) {
                var colorRes = R.drawable.ic_shape_red_circle
                if (index == lotteryNumberArray.size - 1) {
                    colorRes = R.drawable.ic_shape_blue_circle
                }
                lotteryNumberLayout.addView(createTextView(number, colorRes))
            }
        }
    }

    override fun updatePreviousIssue(previousIssueText: String, previousIssueUrl: String) {
        activity?.runOnUiThread {
            lotteryPreviousIssueTextView.text = "上一期：$previousIssueText"
            lotteryPreviousIssueTextView.tag = previousIssueUrl
            lotteryPreviousIssueTextView.setOnClickListener {
                val tag = it.tag as String
                homePresenter.getData(tag)
            }
        }
    }

    fun createTextView(number: String?, colorRes: Int): TextView {
        var textView = TextView(context)
        textView.setBackgroundResource(colorRes)
        textView.text = number
        var layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.leftMargin = 10
        layoutParams.rightMargin = 10
        textView.layoutParams = layoutParams
        textView.gravity = Gravity.CENTER
        return textView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        homePresenter.dropView()
    }
}