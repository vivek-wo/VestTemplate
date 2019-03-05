package com.vest.template.sample.zodiac

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.ImageView
import android.widget.TextView
import com.vest.template.sample.MainPresenter
import com.vest.template.sample.R
import kotlinx.android.synthetic.main.fragment_zodiac.*


class ZodiacFragment : Fragment(), ZodiacView, ViewTreeObserver.OnPreDrawListener {
    lateinit var zodiacPresenter: ZodiacPresenter
    var zodiacAdapter: GridRecyclerAdapter? = null
    var handler: Handler = Handler()


    companion object {
        public var recyclerMeasureHeight: Int = 0
        fun getHeight(): Int {
            return recyclerMeasureHeight
        }

        public fun setHeight(value: Int) {
            recyclerMeasureHeight = value
        }
    }

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
        var layoutManager = GridLayoutManager(context, 3)
        zodiacRecyclerView.layoutManager = layoutManager as RecyclerView.LayoutManager?
        zodiacRecyclerView.viewTreeObserver.addOnPreDrawListener(this)
        zodiacPresenter.getData()
    }

    override fun onPreDraw(): Boolean {
        if ((zodiacRecyclerView.measuredHeight != 0) and (ZodiacFragment.getHeight() == 0)) {
            ZodiacFragment.setHeight(zodiacRecyclerView.measuredHeight)
        }
        return true
    }

    override fun onDestroyView() {
        zodiacRecyclerView.viewTreeObserver.removeOnPreDrawListener(this)
        super.onDestroyView()
        zodiacPresenter.dropView()
    }

    class GridRecyclerAdapter(private val context: Context?, private val zodiacDataList: List<ZodiacData>) :
        RecyclerView.Adapter<GridRecyclerAdapter.ViewHolder>() {
        var itemWidth = 0
        var itemHeight = 0

        init {
            val dm = context!!.resources.displayMetrics
            itemWidth = dm.widthPixels / 3
            itemHeight = dm.heightPixels / 4
        }

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
            val v = LayoutInflater.from(p0!!.context).inflate(R.layout.item_zodiac_grid, p0, false)
            var layoutParams = v.layoutParams
            if (ZodiacFragment.recyclerMeasureHeight != 0) {
                itemHeight = ZodiacFragment.recyclerMeasureHeight / 4
            }
            layoutParams.width = itemWidth
            layoutParams.height = itemHeight
            return ViewHolder(v)
        }

        override fun getItemCount(): Int = zodiacDataList.size


        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
            var iconId =
                context!!.resources.getIdentifier(zodiacDataList[p1].iconName, "drawable", context.getPackageName())
            p0.viewZodiacIcon.setImageResource(iconId)
            p0.viewZodiacName.text = zodiacDataList[p1].name
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var viewZodiacIcon = itemView.findViewById<ImageView>(R.id.viewZodiacIcon)!!
            var viewZodiacName = itemView.findViewById<TextView>(R.id.viewZodiacName)!!
        }
    }

    override fun updateZodiacData(zodiacDataList: List<ZodiacData>) {
        handler.post {
            zodiacAdapter = GridRecyclerAdapter(context, zodiacDataList)
            zodiacRecyclerView.adapter = zodiacAdapter
        }
    }
}