package com.vest.template.sample.welfare

import com.vivek.wo.mvp.basemvp.BaseView

interface WelfareView : BaseView<WelfarePresenter> {

    fun updateLottery(issueNumber: String, issueNumberDate: String)

    fun updateLotteryNumber(lotteryNumberArray: Array<String?>)

    fun updatePreviousIssue(previousIssueText: String, previousIssueUrl: String)
}