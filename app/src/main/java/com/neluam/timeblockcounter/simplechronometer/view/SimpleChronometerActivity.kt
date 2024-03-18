package com.neluam.timeblockcounter.simplechronometer.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.neluam.timeblockcounter.R
import com.neluam.timeblockcounter.databinding.ActivitySimpleChronometerBinding
import com.neluam.timeblockcounter.extensions.viewBinding
import com.neluam.timeblockcounter.simplechronometer.model.LapModel
import com.neluam.timeblockcounter.simplechronometer.model.ChronometerUiState.*
import com.neluam.timeblockcounter.simplechronometer.view.adapter.LapsDetailsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask

@AndroidEntryPoint
class SimpleChronometerActivity : AppCompatActivity(R.layout.activity_simple_chronometer) {

    private val binding by viewBinding(ActivitySimpleChronometerBinding::inflate)

    private val viewModel: SimpleChronometerViewModel by viewModels()

    private val lapsDetailsAdapter = LapsDetailsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initUiListeners()
        clickListeners()
        setupLapsDetailsRecycler()
    }

    private fun initUiListeners() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.statusChronometer.collect{ statusUi ->
                        when (statusUi) {
                            PausedChronometer -> {
                                pausedChronometerConfig()
                            }
                            RunningChronometer -> {
                                runningChronometerConfig()
                            }
                            StanBy -> {
                                standByChronometerConfig()
                            }
                        }
                    }
                }
                launch {
                    viewModel.listLaps.collect { listOfLaps ->
                        if (listOfLaps.isNotEmpty()) {
                            setListToRecyclerView(listOfLaps)
                        } else {
                            hideListLaps()
                        }
                    }
                }
            }
        }
    }


    private fun clickListeners() {
        with(binding) {
            playChronometer.setOnClickListener {
                viewModel.startChronometer()
            }
            pauseChronometer.setOnClickListener {
                viewModel.pauseChronometer()
            }
            resetChronometer.setOnClickListener {
                viewModel.restartChronometer()
                viewModel.cleanTimeLaps()
            }
            addLap.setOnClickListener {
                val timeLap = chronometerText.text.toString()
                viewModel.addLap(timeLap)
            }
        }
    }

    private fun hideListLaps() {
        binding.lapsDetailsContainer.visibility = View.GONE
    }

    private fun standByChronometerConfig() {
        setAnimationStatus(false)
        initialButtons()
    }

    private fun runningChronometerConfig() {
        setTimeText()
        setAnimationStatus(true)
        buttonsOperationChronometer()
    }

    private fun pausedChronometerConfig() {
        setAnimationStatus(false)
        buttonsPausedChronometer()
    }

    private fun buttonsOperationChronometer() {
        with(binding) {
            playChronometer.visibility = View.GONE
            runningButtons.visibility = View.VISIBLE
            addLap.visibility = View.VISIBLE
        }
    }

    private fun buttonsPausedChronometer() {
        with(binding) {
            playChronometer.text = getString(R.string.btn_continue_chronometer)
            playChronometer.visibility = View.VISIBLE
            addLap.visibility = View.GONE
        }
    }

    private fun initialButtons() {
        with(binding) {
            playChronometer.text = getString(R.string.btn_play_chronometer)
            playChronometer.visibility = View.VISIBLE
            runningButtons.visibility = View.GONE
            addLap.visibility = View.GONE
            hideListLaps()
        }
    }

    private fun setAnimationStatus(showAnimation: Boolean) {
        if (showAnimation) {
            binding.animationChronometer.playAnimation()
        } else {
            binding.animationChronometer.pauseAnimation()
        }
    }

    private fun setTimeText() {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val time = viewModel.getCurrentTime()
                    val seconds = (time / PERIOD_TIME).toInt() % SECONDS
                    val minutes = (time / (PERIOD_TIME * SECONDS) % MINUTES)
                    val hours = (time / (PERIOD_TIME * SECONDS * MINUTES) % HOURS)

                    binding.chronometerText.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)
                }
            }
        }, DELAY, PERIOD_TIME)
    }

    private fun setupLapsDetailsRecycler() {
        binding.lapsDetails.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SimpleChronometerActivity)
        }

    }

    private fun setListToRecyclerView(listLapsTime: List<LapModel>) {
        with(binding) {
            headerLapsDetails.idLap.text = getString(R.string.header_id_text)
            headerLapsDetails.timeLap.text = getString(R.string.header_time_text)
            lapsDetailsContainer.visibility = View.VISIBLE
            lapsDetailsAdapter.LapsDetailsAdapter(listLapsTime)
            lapsDetails.adapter = lapsDetailsAdapter
        }
    }

    companion object {
        const val PERIOD_TIME = 1000L
        const val SECONDS = 60
        const val MINUTES = 60
        const val HOURS = 24
        const val DELAY = 0L
    }

}