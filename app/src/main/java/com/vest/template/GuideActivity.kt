package com.vest.template

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.vest.template.sample.R
import kotlinx.android.synthetic.main.activity_guide.*

class GuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        guideViewPager.adapter = PagerAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    class PagerAdapter : android.support.v4.view.PagerAdapter() {

        val GUIDE_IMAGEIDS = arrayOf(
            R.drawable.image_guide_01,
            R.drawable.image_guide_02,
            R.drawable.image_guide_03
        )

        override fun isViewFromObject(p0: View, p1: Any): Boolean {
            return p0 == p1
        }

        override fun getCount(): Int {
            return GUIDE_IMAGEIDS.size
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var imageView = ImageView(container.context)
            imageView.setImageResource(GUIDE_IMAGEIDS[position])
            container.addView(imageView)
            return imageView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View?)
        }
    }
}