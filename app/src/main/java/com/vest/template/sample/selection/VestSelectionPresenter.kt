package com.vest.template.sample.selection

import com.vivek.wo.mvp.basemvp.BasePresenter

class VestSelectionPresenter : BasePresenter<VestSelectionView> {

    var vestSelectionView: VestSelectionView? = null

    override fun takeView(view: VestSelectionView?) {
        vestSelectionView = view
    }

    override fun dropView() {
        vestSelectionView = null
    }

}