package com.neluam.timeblockcounter.routinecycled

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neluam.timeblockcounter.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoutineCycledActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine_cycled)
    }
}