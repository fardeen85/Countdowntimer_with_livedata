package com.example.countdowntimerlivedata

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Viewmodel  : ViewModel(){

    lateinit var timer : CountDownTimer
    private val seconds  = MutableLiveData<Int>()
    private val booleanlivedata = MutableLiveData<Boolean>()
    var timervalue = MutableLiveData<Long>()


    fun startimer(){

        timer = object : CountDownTimer(timervalue.value!!.toLong(),1000){
            override fun onFinish() {

                booleanlivedata.value = true
            }

            override fun onTick(millisUntilFinished: Long) {

                val finishtime = millisUntilFinished/1000

                seconds.value = finishtime.toInt()
            }


        }.start()
    }

    fun finish() : LiveData<Boolean>{

        return  booleanlivedata

    }

    fun seconds() : LiveData<Int>{

        return seconds
    }


    fun stoptimer(){

        timer.cancel()
    }


}