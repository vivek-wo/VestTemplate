package com.vest.template.sample.selection

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.vest.template.sample.R
import kotlinx.android.synthetic.main.activity_vestselection.*

class VestSelectionActivity : AppCompatActivity() {

    lateinit var vestSelectionPresenter: VestSelectionPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vestselection)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}