package com.vest.template.sample.sports

import com.vivek.wo.mvp.basemvp.BaseView

interface SportsView : BaseView<SportsPresenter> {
    fun updateLottery(issueNumber: String, issueNumberDate: String)

    fun updateLotteryNumber(lotteryNumberArray: Array<String?>)

    fun updatePreviousIssue(previousIssueText: String, previousIssueUrl: String)
}