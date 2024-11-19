package com.neluam.timeblockcounter.commons.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.neluam.timeblockcounter.R

@Preview(showBackground = true)
@Composable
fun ItemOptionMain(
    title: String = "Item",
    icon: Int = R.drawable.ic_watch
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(COMMON_PADDING_MIN)
    ) {
        ConstraintLayout {
            val (iconView, titleView) = createRefs()

            Image(
                modifier = Modifier
                    .padding(COMMON_PADDING_MIN)
                    .width(ICON_DIMEN)
                    .height(ICON_DIMEN)
                    .constrainAs(iconView){
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    },
                painter = painterResource(icon),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(COMMON_PADDING_MIN)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .constrainAs(titleView){
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(iconView.end)
                    },
                text = title,
                maxLines = 2
            )
        }
    }
}