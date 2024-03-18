package com.neluam.timeblockcounter.simpletimer.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.neluam.timeblockcounter.R
import com.neluam.timeblockcounter.databinding.ActivitySimpleTimerBinding
import com.neluam.timeblockcounter.extensions.viewBinding
import com.neluam.timeblockcounter.simpletimer.model.SimpleTimerUiState.*
import kotlinx.coroutines.launch

class SimpleTimerActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivitySimpleTimerBinding::inflate)

    private val viewModel: SimpleTimerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initListeners()
        initSetOnClickListeners()
    }

    private fun initSetOnClickListeners() {
        with(binding){
            pauseTimer.setOnClickListener { viewModel.pauseTimer() }
            resetTimer.setOnClickListener { viewModel.cancelTimer() }
        }
    }

    private fun initListeners() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.uiStatueSimpleTimer.collect { uiState ->
                        when (uiState) {
                            PausedTimer -> {
                                configureResumeTimerButton()
                            }
                            RunningTimer -> {

                            }
                            StanBy -> {
                                configureStartTimerButton()
                            }
                        }
                    }
                }
                launch {
                    viewModel.currentTime.collect { time ->
                        if (time.isNotEmpty()) {
                            binding.timeText.text = time
                        }
                    }
                }
                launch {
                    viewModel.progressStatusTimer.collect { progress ->
                        binding.progressTime.progress = progress
                    }
                }
            }
        }
    }

    private fun configureStartTimerButton() {
        binding.playTimer.apply{
            text = getString(R.string.btn_play_chronometer)
            setOnClickListener { viewModel.startTimer("") }
        }
    }

    private fun configureResumeTimerButton() {
        binding.playTimer.apply{
            text = getString(R.string.btn_continue_chronometer)
            setOnClickListener { viewModel.resumeTimer() }
        }
    }

}