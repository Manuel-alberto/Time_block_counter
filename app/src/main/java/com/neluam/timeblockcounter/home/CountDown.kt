package com.neluam.timeblockcounter.home

import android.os.CountDownTimer
import javax.inject.Inject

class CountDown @Inject constructor() {

    private lateinit var timer: CountDownTimer
    private var timeRemaining = 0L
    private var isPaused = false

    fun init(listBlocksTime: List<TimeBlock>, onTick:(Long) -> Unit, onFinish: () -> Unit) {

        var time: Long = 0
        listBlocksTime.forEach {
            time += it.time
        }

        timer = object: CountDownTimer(time, 1000L){
            override fun onTick(millisUntilFinished: Long) {
                if (!isPaused) {
                    timeRemaining = millisUntilFinished
                }
                onTick.invoke(millisUntilFinished)
            }
            override fun onFinish() {
                onFinish.invoke()
            }

        }

        timer.start()
    }

    fun pauseCountdownTimer() {
        isPaused = true
        timer.cancel()
    }

    /*fun resumeCountdownTimer(listBlocksTime: List<TimeBlock>, onTick:(Long) -> Unit, onFinish: () -> Unit) {
        isPaused = false
        init(listBlocksTime, { onTick() }, { onFinish.invoke() })
    }*/

}