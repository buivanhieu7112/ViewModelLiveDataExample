package com.example.framgiabuivanhieu.livedataexample

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {
    private lateinit var mMedalViewModel: MedalViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mMedalViewModel = ViewModelProviders.of(activity!!).get(MedalViewModel::class.java)
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mMedalViewModel.mNumberOfGoldMedal.observe(activity!!, Observer<Int> { displayMedal() })
        mMedalViewModel.mNumberOfSilverMedal.observe(activity!!, Observer<Int> { displayMedal() })
        mMedalViewModel.mNumberOfBronzeMedal.observe(activity!!, Observer<Int> { displayMedal() })
        displayMedal()
    }

    @SuppressLint("SetTextI18n")
    private fun displayMedal() {
        textViewGoldDetail.text =
                activity!!.getString(R.string.number_of_gold_medal) + mMedalViewModel.mNumberOfGoldMedal.value!!
        textViewSilverDetail.text =
                activity!!.getString(R.string.number_of_silver_medal) + mMedalViewModel.mNumberOfSilverMedal.value!!
        textViewBronzeDetail.text =
                activity!!.getString(R.string.number_of_bronze_medal) + mMedalViewModel.mNumberOfBronzeMedal.value!!
    }

    companion object {
        fun newInstance(): DetailFragment {
            return DetailFragment()
        }
    }
}
