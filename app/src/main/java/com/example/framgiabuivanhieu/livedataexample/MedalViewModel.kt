package com.example.framgiabuivanhieu.livedataexample

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData

class MedalViewModel(application: Application) : AndroidViewModel(application) {
    var mNumberOfGoldMedal: MutableLiveData<Int> = MutableLiveData()
    var mNumberOfSilverMedal: MutableLiveData<Int> = MutableLiveData()
    var mNumberOfBronzeMedal: MutableLiveData<Int> = MutableLiveData()

    init {
        mNumberOfGoldMedal.value = 0
        mNumberOfSilverMedal.value = 0
        mNumberOfBronzeMedal.value = 0
    }
}