package com.neluam.timeblockcounter.commons.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.neluam.timeblockcounter.R

@Composable
fun ButtonSimple(
    modifier: Modifier = Modifier,
    text: String = "Simple Button",
    onClick: () -> Unit = {}
){
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Colors.primary)
    ) {
        Text( text )
    }
}

@Composable
fun ButtonWithIcon(
    modifier: Modifier = Modifier,
    text: String = "Icon Button",
    icon: Int = R.drawable.ic_watch,
    onClick: () -> Unit = {}
){
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Colors.primary)
    ) {
        Icon(painter = painterResource(icon), contentDescription = null)
        Spacer(modifier = Modifier.width(COMMON_PADDING_MINI))
        Text( text )
    }
}

@Preview
@Composable
fun ButtonsCatalog() {
    Column {
        ButtonSimple()
        ButtonWithIcon()
    }
}