package com.neluam.timeblockcounter.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.neluam.timeblockcounter.R
import com.neluam.timeblockcounter.databinding.ActivityHomeBinding
import com.neluam.timeblockcounter.extensions.viewBinding
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

        /*val list: List<TimeBlock> = listOf(
            TimeBlock(10000, "Primero"),
            TimeBlock(10000, "Segundo"),
            TimeBlock(10000, "tercero")
        )

        viewModel.initTimer(list)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.stateTime.collect{
                    binding.state.text = it
                }
            }
        }*/

    }

    private fun initItemsOptions() {
        with(binding) {
            itemSimpleChronometer.apply {
                iconAction.setImageResource(R.drawable.ic_watch)
                titleAction.text = getString(R.string.option_simple_chronometer)
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
                Toast.makeText(this@HomeActivity, "itemSimpleChronometer", Toast.LENGTH_SHORT).show()
            }
            itemSimpleRoutine.root.setOnClickListener {
                Toast.makeText(this@HomeActivity, "itemSimpleRoutine", Toast.LENGTH_SHORT).show()
            }
            itemCycledRoutine.root.setOnClickListener {
                Toast.makeText(this@HomeActivity, "itemCycledRoutine", Toast.LENGTH_SHORT).show()
            }
        }
    }
}