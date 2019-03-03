package com.vest.template.sample.zodiac

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vest.template.sample.MainPresenter
import com.vest.template.sample.R

class ZodiacFragment : Fragment(), ZodiacView {
    lateinit var zodiacPresenter: ZodiacPresenter

    override fun setPresenter(presenter: MainPresenter?) {
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_zodiac, null)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        zodiacPresenter = ZodiacPresenter(context!!)
        zodiacPresenter.takeView(this)
        zodiacPresenter.getData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        zodiacPresenter.dropView()
    }

    class GridRecyclerAdapter(val zodiacDataList: List<ZodiacData>) :
        RecyclerView.Adapter<GridRecyclerAdapter.ViewHolder>() {

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
            val v = LayoutInflater.from(p0!!.context).inflate(R.layout.item_zodiac_grid, p0, false)
            return ViewHolder(v)
        }

        override fun getItemCount(): Int = zodiacDataList.size

        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        }
    }
}