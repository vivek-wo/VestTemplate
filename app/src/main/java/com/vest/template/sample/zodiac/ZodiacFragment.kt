package com.vest.template.sample.zodiac

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vest.template.sample.MainPresenter
import com.vest.template.sample.R

class ZodiacFragment : Fragment(), ZodiacView {
    override fun setPresenter(presenter: MainPresenter?) {
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_zodiac, null)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}