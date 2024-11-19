package com.neluam.timeblockcounter.home.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.neluam.timeblockcounter.R
import com.neluam.timeblockcounter.commons.ui.COMMON_PADDING_DEFAULT
import com.neluam.timeblockcounter.home.ui.theme.GreenBlue


@Composable
fun ImageHeader() {
    ConstraintLayout(
        modifier = Modifier
            .background(
                color = GreenBlue,
            )
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(COMMON_PADDING_DEFAULT)
    ) {
        val (hello, message, image) = createRefs()

        Image(
            modifier = Modifier.constrainAs(image) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }
                .size(130.dp),
            painter = painterResource(R.drawable.img_main_header),
            contentDescription = null
        )

        Text(
            modifier = Modifier.constrainAs(hello){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            },
            text = "Hola!",
            color = Color.White,
            fontSize = 30.sp
        )

        Text(
            modifier = Modifier.constrainAs(message){
                top.linkTo(image.top)
                bottom.linkTo(image.bottom)
                start.linkTo(parent.start)
            },
            text = "¿Que desea hacer hoy?",
            color = Color.White,
            fontSize =15.sp
        )

    }
}