package com.vest.template.sample

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.vest.template.sample.mine.MineFragment
import com.vest.template.sample.selection.VestSelectionActivity
import com.vest.template.sample.sports.SportsFragment
import com.vest.template.sample.welfare.WelfareFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainView {
    lateinit var mainPresenter: MainPresenter
    var homeFragment: WelfareFragment? = null
    var sportsFragment: SportsFragment? = null
    var mineFragment: MineFragment? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                if (homeFragment == null) {
                    homeFragment = WelfareFragment();
                }
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, homeFragment!!).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                if (sportsFragment == null) {
                    sportsFragment = SportsFragment();
                }
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, sportsFragment!!).commit()
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
        setSupportActionBar(toolbar)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        mainPresenter = MainPresenter()
        mainPresenter.takeView(this)
        navigation.selectedItemId = R.id.navigation_home
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_menu_cart -> {
                startActivity(Intent(this, VestSelectionActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
