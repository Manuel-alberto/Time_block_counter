package com.neluam.timeblockcounter.simplechronometer.view

import androidx.lifecycle.ViewModel
import com.neluam.timeblockcounter.simplechronometer.model.LapModel
import com.neluam.timeblockcounter.simplechronometer.model.ChronometerUiState
import com.neluam.timeblockcounter.simplechronometer.model.ChronometerUiState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SimpleChronometerViewModel @Inject constructor(): ViewModel(){

    private var startTime: Long = 0
    private var elapsedTime: Long = 0

    private var _statusChronometer = MutableStateFlow<ChronometerUiState>(StanBy)
    val statusChronometer = _statusChronometer.asStateFlow()

    private var listTimeLaps = mutableListOf<LapModel>()

    private var _listLaps = MutableStateFlow<List<LapModel>>(ArrayList())
    val listLaps = _listLaps.asStateFlow()

    fun startChronometer() {
        if (statusChronometer.value is StanBy || statusChronometer.value is PausedChronometer) {
            startTime = System.currentTimeMillis() - elapsedTime
            _statusChronometer.value = RunningChronometer
        }
    }

    fun pauseChronometer() {
        if (statusChronometer.value is RunningChronometer) {
            elapsedTime = System.currentTimeMillis() - startTime
            _statusChronometer.value = PausedChronometer
        }
    }

    fun restartChronometer() {
        elapsedTime = 0
        _statusChronometer.value = StanBy
    }

    fun getCurrentTime(): Long {
        return if (statusChronometer.value is RunningChronometer) {
            System.currentTimeMillis() - startTime
        } else {
            elapsedTime
        }
    }

    fun addLap(time: String) {
        listTimeLaps.add(LapModel((listTimeLaps.size +1), time) )
        _listLaps.value = listTimeLaps.toList().asReversed()
    }

    fun cleanTimeLaps() {
        listTimeLaps.clear()
        _listLaps.value = emptyList()
    }

}