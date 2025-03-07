package com.neluam.timeblockcounter.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.neluam.timeblockcounter.R
import com.neluam.timeblockcounter.commons.ui.COMMON_PADDING_MIDDLE
import com.neluam.timeblockcounter.home.components.ImageHeader
import com.neluam.timeblockcounter.home.components.OptionMenuItem

@Preview(showBackground = true, device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun MenuScreen(
    sendToSimpleChronometer: PaddingValues = PaddingValues()
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ){
        ImageHeader()
        Spacer(Modifier.height(COMMON_PADDING_MIDDLE))
        OptionMenuItem(
            icon =R.drawable.ic_watch,
            title = stringResource(R.string.option_simple_chronometer),
        ) {
        }
    }
}

