package com.neluam.timeblockcounter.simplechronometer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showBackground = true)
@Composable
fun LapsList(
    lapsList: List<String> = listOf("05:00", "07:00", "10:00")
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        HeaderLapsList()
        lapsList.forEachIndexed { index,item ->
            LapsItem(index, item)
        }
    }
}

@Composable
fun HeaderLapsList(modifier: Modifier = Modifier){
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ){
        val (timeTopic, timeLap) = createRefs()
        Text(
            modifier = Modifier.constrainAs(timeTopic){
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(timeLap.start)
            },
            text = "Vuelta"
        )
        Text(
            modifier = Modifier.constrainAs(timeLap){
                start.linkTo(timeTopic.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            },
            text = "Tiempo"
        )
    }
}

@Composable
fun LapsItem(
    index: Int,
    time: String
){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(if(index % 2 == 0) Color.White else Color.Gray)
    ) {
        val (indexLabel, timeLabel) = createRefs()
        Text(
            modifier = Modifier.constrainAs(indexLabel){
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(timeLabel.start)
            },
            text = index.toString()
        )
        Text(
            modifier = Modifier.constrainAs(timeLabel){
                start.linkTo(indexLabel.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            },
            text = time
        )
    }
}