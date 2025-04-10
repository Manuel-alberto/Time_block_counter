package com.neluam.timeblockcounter.simplechronometer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun SimpleChronometer(
    //viewModel = SimpleChronometerViewModel = hiltViewModel()
){
    Column(
        modifier = Modifier
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(300.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun PreviewSimpleChronometer() {
    SimpleChronometer()
}