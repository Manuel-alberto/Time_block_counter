package com.neluam.timeblockcounter.simplechronometer.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.neluam.timeblockcounter.R
import com.neluam.timeblockcounter.commons.ui.ButtonWithIcon
import com.neluam.timeblockcounter.commons.ui.COMMON_PADDING_MINI

@Preview(showBackground = true)
@Composable
fun ChronometerButtonsControl() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        RunningControls()
    }
}

@Preview(showBackground = true)
@Composable
fun PausedControls() {
    ConstraintLayout(
        modifier = Modifier
            .padding(COMMON_PADDING_MINI)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val (continueButton, resetButton) = createRefs()
        ButtonWithIcon(
            modifier = Modifier.constrainAs(continueButton) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            },
            text = "Continuar")
        ButtonWithIcon(
            modifier = Modifier.constrainAs(resetButton) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            },
            text = "Reiniciar",
            icon = R.drawable.ic_clock_cycled)
    }
}

@Preview(showBackground = true)
@Composable
fun StartControls() {
    ConstraintLayout(
        modifier = Modifier
            .padding(COMMON_PADDING_MINI)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val (startButton) = createRefs()
        ButtonWithIcon(
            modifier = Modifier.constrainAs(startButton) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            },
            text = "Iniciar")
    }
}

@Preview(showBackground = true)
@Composable
fun RunningControls(isRunning: Boolean = false) {
    ConstraintLayout(
        modifier = Modifier
            .padding(COMMON_PADDING_MINI)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val (pause, reset, lap) = createRefs()
        ButtonWithIcon(
            modifier = Modifier.constrainAs(pause) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            },
            text = "Pausar")
        ButtonWithIcon(
            modifier = Modifier.constrainAs(reset) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            },
            text = "Reiniciar",
            icon = R.drawable.ic_clock_cycled)
        ButtonWithIcon(
            modifier = Modifier.constrainAs(lap) {
                top.linkTo(pause.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = "Vuelta",
            icon = R.drawable.ic_add)
    }
}
