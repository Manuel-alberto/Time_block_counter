package com.neluam.timeblockcounter.simplechronometer.model

sealed class ChronometerUiState {
    object StanBy: ChronometerUiState()
    object RunningChronometer: ChronometerUiState()
    object PausedChronometer: ChronometerUiState()
}