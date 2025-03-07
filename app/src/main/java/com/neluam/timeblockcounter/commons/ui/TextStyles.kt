package com.neluam.timeblockcounter.commons.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NormalText(
    modifier: Modifier = Modifier,
    text: String = "Normal Text"
    ){
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontFamily = normalFont,
            fontSize = body1,
        )
    )
}

@Composable
fun SecondaryText(
    modifier: Modifier = Modifier,
    text: String = "Secondary Text"
){
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontFamily = normalFont,
            fontSize = body2,
        )
    )
}

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    text: String = "Title Text"
){
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontFamily = normalFont,
            fontSize = h2,
        )
    )
}

@Composable
fun ButtonText(
    modifier: Modifier = Modifier,
    text: String = "Button Text"
){
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontFamily = normalFont,
            fontSize = button,
        )
    )
}

@Composable
fun LabelsText(
    modifier: Modifier = Modifier,
    text: String = "Labels Text"
){
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontFamily = normalFont,
            fontSize = caption,
        )
    )
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun PreviewText(){
    Column {
        NormalText(modifier = Modifier.padding(COMMON_PADDING_MINI))
        SecondaryText(modifier = Modifier.padding(COMMON_PADDING_MINI))
        TitleText(modifier = Modifier.padding(COMMON_PADDING_MINI))
        ButtonText(modifier = Modifier.padding(COMMON_PADDING_MINI))
        LabelsText(modifier = Modifier.padding(COMMON_PADDING_MINI))
    }
}