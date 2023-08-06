package com.neluam.timeblockcounter.Home

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val countDown: CountDown
): ViewModel() {

    private var _stateFlow = MutableStateFlow(false)
    val stateFlow: StateFlow<Boolean> = _stateFlow

    private var _stateTime = MutableStateFlow("00:00")
    val stateTime: StateFlow<String> = _stateTime

    fun setStateFlow(state: Boolean) {
        _stateFlow.value = state
    }

    fun initTimer(listBlocksTime: List<TimeBlock>) {

    }

}