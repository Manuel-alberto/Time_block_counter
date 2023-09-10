package com.neluam.timeblockcounter.routinesimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neluam.timeblockcounter.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoutineSimpleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine_simple)
    }
}