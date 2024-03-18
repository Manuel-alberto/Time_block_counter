package com.neluam.timeblockcounter.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.neluam.timeblockcounter.R
import com.neluam.timeblockcounter.databinding.ActivityHomeBinding
import com.neluam.timeblockcounter.extensions.navigateTo
import com.neluam.timeblockcounter.extensions.viewBinding
import com.neluam.timeblockcounter.routinecycled.RoutineCycledActivity
import com.neluam.timeblockcounter.routinesimple.RoutineSimpleActivity
import com.neluam.timeblockcounter.simplechronometer.view.SimpleChronometerActivity
import com.neluam.timeblockcounter.simpletimer.view.SimpleTimerActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity: AppCompatActivity(R.layout.activity_home) {

    private val binding by viewBinding(ActivityHomeBinding::inflate)
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initItemsOptions()
        clickListeners()

    }

    private fun initItemsOptions() {
        with(binding) {
            itemSimpleChronometer.apply {
                iconAction.setImageResource(R.drawable.ic_watch)
                titleAction.text = getString(R.string.option_simple_chronometer)
            }
            itemSimpleTimer.apply {
                iconAction.setImageResource(R.drawable.ic_simple_timer)
                titleAction.text = getString(R.string.option_simple_timer)
            }
            itemSimpleRoutine.apply {
                iconAction.setImageResource(R.drawable.ic_add_clock)
                titleAction.text = getString(R.string.option_simple_routine)
            }
            itemCycledRoutine.apply {
                iconAction.setImageResource(R.drawable.ic_clock_cycled)
                titleAction.text = getString(R.string.option_cycled_routine)
            }
        }
    }
    
    private fun clickListeners() {
        with(binding) {
            itemSimpleChronometer.root.setOnClickListener {
                navigateTo(Intent(this@HomeActivity, SimpleChronometerActivity::class.java), this@HomeActivity)
            }
            itemSimpleTimer.root.setOnClickListener {
                navigateTo(Intent(this@HomeActivity, SimpleTimerActivity::class.java), this@HomeActivity)
            }
            itemSimpleRoutine.root.setOnClickListener {
                navigateTo(Intent(this@HomeActivity, RoutineSimpleActivity::class.java), this@HomeActivity)
            }
            itemCycledRoutine.root.setOnClickListener {
                navigateTo(Intent(this@HomeActivity, RoutineCycledActivity::class.java), this@HomeActivity)
            }
        }
    }
}