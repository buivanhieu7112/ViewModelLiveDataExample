package com.example.framgiabuivanhieu.livedataexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        var fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.layoutFragmentSummary, SummaryFragment.newInstance())
        fragmentTransaction.add(R.id.layoutFragmentControl, ControlFragment.newInstance())
        fragmentTransaction.add(R.id.layoutFragmentDetail, DetailFragment.newInstance())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
