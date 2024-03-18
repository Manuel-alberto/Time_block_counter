package com.neluam.timeblockcounter.simpletimer.model

sealed class SimpleTimerUiState {
    object StanBy: SimpleTimerUiState()
    object RunningTimer: SimpleTimerUiState()
    object PausedTimer: SimpleTimerUiState()
}