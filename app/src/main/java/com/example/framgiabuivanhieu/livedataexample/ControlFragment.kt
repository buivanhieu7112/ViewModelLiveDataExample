package com.example.framgiabuivanhieu.livedataexample

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_control.*

class ControlFragment : Fragment(), View.OnClickListener {
    private lateinit var mMedalViewModel: MedalViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mMedalViewModel = ViewModelProviders.of(activity!!).get(MedalViewModel::class.java)
        return layoutInflater.inflate(R.layout.fragment_control, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonMinusGoldMedal.setOnClickListener(this)
        buttonMinusSilverMedal.setOnClickListener(this)
        buttonMinusBronzeMedal.setOnClickListener(this)
        buttonPlusSilverMedal.setOnClickListener(this)
        buttonPlusGoldMedal.setOnClickListener(this)
        buttonPlusBronzeMedal.setOnClickListener(this)
    }

    private fun displayMedal() {
        textViewGoldNumber.text = mMedalViewModel.mNumberOfGoldMedal.value?.toString()
        textViewSilverNumber.text = mMedalViewModel.mNumberOfSilverMedal.value?.toString()
        textViewBronzeNumber.text = mMedalViewModel.mNumberOfBronzeMedal.value?.toString()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            buttonPlusGoldMedal.id -> {
                mMedalViewModel.mNumberOfGoldMedal.value = mMedalViewModel.mNumberOfGoldMedal.value?.plus(1)
                displayMedal()
            }
            buttonPlusSilverMedal.id -> {
                mMedalViewModel.mNumberOfSilverMedal.value = mMedalViewModel.mNumberOfSilverMedal.value?.plus(1)
                displayMedal()
            }
            buttonPlusBronzeMedal.id -> {
                mMedalViewModel.mNumberOfBronzeMedal.value = mMedalViewModel.mNumberOfBronzeMedal.value?.plus(1)
                displayMedal()
            }
            buttonMinusGoldMedal.id -> {
                mMedalViewModel.mNumberOfGoldMedal.value = mMedalViewModel.mNumberOfGoldMedal.value?.minus(1)
                displayMedal()
            }
            buttonMinusSilverMedal.id -> {
                mMedalViewModel.mNumberOfSilverMedal.value = mMedalViewModel.mNumberOfSilverMedal.value?.minus(1)
                displayMedal()
            }
            buttonMinusBronzeMedal.id -> {
                mMedalViewModel.mNumberOfBronzeMedal.value = mMedalViewModel.mNumberOfBronzeMedal.value?.minus(1)
                displayMedal()
            }
        }
    }

    companion object {
        fun newInstance(): ControlFragment {
            return ControlFragment()
        }
    }
}
