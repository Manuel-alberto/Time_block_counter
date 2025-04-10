package com.neluam.timeblockcounter.navigation

sealed class ScreenId(val route: String) {
    object Main: ScreenId("MainScreen")
    object SimpleChronometer: ScreenId("SimpleChronometerScreen")
}