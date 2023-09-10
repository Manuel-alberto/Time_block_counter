package com.neluam.timeblockcounter.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.neluam.timeblockcounter.R
import com.neluam.timeblockcounter.databinding.ActivityHomeBinding
import com.neluam.timeblockcounter.databinding.ActivityMainBinding
import com.neluam.timeblockcounter.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity: AppCompatActivity(R.layout.activity_home) {

    private val binding by viewBinding(ActivityHomeBinding::inflate)
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val list: List<TimeBlock> = listOf(
            TimeBlock(10000, "Primero"),
            TimeBlock(10000, "Segundo"),
            TimeBlock(10000, "tercero")
        )

        viewModel.initTimer(list)

        /*lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.stateTime.collect{
                    binding.state.text = it
                }
            }
        }*/

    }
}