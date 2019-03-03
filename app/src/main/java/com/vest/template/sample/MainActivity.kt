package com.vest.template.sample

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.vest.template.sample.home.HomeFragment
import com.vest.template.sample.mine.MineFragment
import com.vest.template.sample.zodiac.ZodiacFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainView {
    lateinit var mainPresenter: MainPresenter
    var homeFragment: HomeFragment? = null
    var zodiacFragment: ZodiacFragment? = null
    var mineFragment: MineFragment? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                if (homeFragment == null) {
                    homeFragment = HomeFragment();
                }
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, homeFragment!!).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                if (zodiacFragment == null) {
                    zodiacFragment = ZodiacFragment();
                }
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, zodiacFragment!!).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                if (mineFragment == null) {
                    mineFragment = MineFragment();
                }
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, mineFragment!!).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun setPresenter(presenter: MainPresenter?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        mainPresenter = MainPresenter()
        mainPresenter.takeView(this)
    }

}
