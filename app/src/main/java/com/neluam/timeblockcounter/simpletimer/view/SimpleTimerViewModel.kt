package com.neluam.timeblockcounter.simpletimer.view

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel
import com.neluam.timeblockcounter.simpletimer.model.SimpleTimerUiState
import com.neluam.timeblockcounter.simpletimer.model.SimpleTimerUiState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SimpleTimerViewModel @Inject constructor(): ViewModel() {

    private val _uiStatueSimpleTimer = MutableStateFlow<SimpleTimerUiState>(StanBy)
    var uiStatueSimpleTimer = _uiStatueSimpleTimer.asStateFlow()

    private lateinit var countDownTimer: CountDownTimer
    private var timerRunning = false

    private var initialTimeMillis: Long = 0
    private var timeLeftMillis: Long = 0

    private val _currentTime = MutableStateFlow("00:00:05")
    val currentTime  = _currentTime.asStateFlow()

    private val _progressStatusTimer = MutableStateFlow(100)
    val progressStatusTimer = _progressStatusTimer.asStateFlow()

    fun startTimer(time: String) {
        if (!timerRunning) {
            val timeParts = currentTime.value.split(":")
            val hours = timeParts[0].toLong()
            val minutes = timeParts[1].toLong()
            val seconds = timeParts[2].toLong()

            initialTimeMillis = (hours * 3600 + minutes * 60 + seconds) * 1000
            timeLeftMillis = initialTimeMillis

            countDownTimer = object : CountDownTimer(initialTimeMillis, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    timeLeftMillis = millisUntilFinished
                    updateTimer(millisUntilFinished)
                    _progressStatusTimer.value = getPercentageProgress(initialTimeMillis, millisUntilFinished)
                    Log.e("timer", "$timeLeftMillis")
                    Log.e("timer", "${_progressStatusTimer.value}")
                }

                override fun onFinish() {
                    timerRunning = false
                    _progressStatusTimer.value = 0
                    _currentTime.value = "00:00:00"
                }
            }.start()

            timerRunning = true
            _uiStatueSimpleTimer.value = RunningTimer
        }
    }

    private fun getPercentageProgress(timeComplete: Long, timeRemaining: Long): Int =
        (timeRemaining.toInt() * 100) / timeComplete.toInt()

    fun pauseTimer() {
        if (timerRunning && uiStatueSimpleTimer.value !is PausedTimer) {
            countDownTimer.cancel()
            _uiStatueSimpleTimer.value = PausedTimer
        }
    }

    fun resumeTimer() {
        if (timerRunning && uiStatueSimpleTimer.value is PausedTimer) {
            startTimer(formatTime(timeLeftMillis))
            _uiStatueSimpleTimer.value = RunningTimer
        }
    }

    fun cancelTimer() {
        if (timerRunning) {
            countDownTimer.cancel()
            timerRunning = false
        }
    }

    private fun updateTimer(time: Long) {

        val hours = (time / 1000) / 3600
        val minutes = ((time / 1000) % 3600) / 60
        val seconds = (time / 1000) % 60

        val timeString = "${formatDigit(hours)}:${formatDigit(minutes)}:${formatDigit(seconds)}"
        _currentTime.value = timeString
    }

    private fun formatDigit(number: Long): String {
        return if (number < 10) "0$number" else number.toString()
    }

    private fun formatTime(millis: Long): String {
        val hours = (millis / 1000) / 3600
        val minutes = ((millis / 1000) % 3600) / 60
        val seconds = (millis / 1000) % 60

        return "${formatDigit(hours)}:${formatDigit(minutes)}:${formatDigit(seconds)}"
    }

}