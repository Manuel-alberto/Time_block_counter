package com.neluam.timeblockcounter.simplechronometer

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true, device = Devices.PIXEL_4, showBackground = true)
@Composable
fun SimpleChronometer(){
    CircularProgressIndicator()

}