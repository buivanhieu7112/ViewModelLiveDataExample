package com.example.framgiabuivanhieu.livedataexample

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_summary.*

class SummaryFragment : Fragment() {
    private lateinit var mMedalViewModel: MedalViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mMedalViewModel = ViewModelProviders.of(activity!!).get(MedalViewModel::class.java)
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mMedalViewModel.mNumberOfGoldMedal.observe(activity!!, Observer<Int> { displayMedal() })
        mMedalViewModel.mNumberOfSilverMedal.observe(activity!!, Observer<Int> { displayMedal() })
        mMedalViewModel.mNumberOfBronzeMedal.observe(activity!!, Observer<Int> { displayMedal() })
    }

    @SuppressLint("SetTextI18n")
    private fun displayMedal() {
        val totalMedal = mMedalViewModel.mNumberOfGoldMedal.value!!.plus(mMedalViewModel.mNumberOfSilverMedal.value!!)
            .plus(mMedalViewModel.mNumberOfBronzeMedal.value!!)
        textViewNumberOfMedal.text = activity?.getString(R.string.number_of_medal) + " " + totalMedal.toString()
    }

    companion object {
        fun newInstance(): SummaryFragment {
            return SummaryFragment()
        }
    }
}
