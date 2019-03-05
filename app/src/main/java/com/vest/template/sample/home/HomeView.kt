package com.vest.template.sample.home

import com.vest.template.sample.MainPresenter
import com.vivek.wo.mvp.basemvp.BaseView

interface HomeView : BaseView<MainPresenter> {

    fun updateLottery(issueNumber: String, issueNumberDate: String)

    fun updateLotteryNumber(lotteryNumberArray: Array<String?>)

    fun updatePreviousIssue(previousIssueText: String, previousIssueUrl: String)
}