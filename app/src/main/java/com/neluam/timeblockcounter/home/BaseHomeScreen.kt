package com.neluam.timeblockcounter.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.neluam.timeblockcounter.home.ui.theme.TimeBlockCounterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseHomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimeBlockCounterTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MenuScreen(innerPadding)
                }
            }
        }
    }
}


