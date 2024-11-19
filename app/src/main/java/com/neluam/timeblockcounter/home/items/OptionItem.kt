package com.neluam.timeblockcounter.home.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neluam.timeblockcounter.R
import com.neluam.timeblockcounter.commons.ui.COMMON_PADDING_DEFAULT
import com.neluam.timeblockcounter.commons.ui.COMMON_PADDING_MIN

@Preview(showBackground = true)
@Composable
fun OptionMenuItem(
    icon: Int = R.drawable.ic_watch,
    title: String = "Item",
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(24.dp)
            )
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(COMMON_PADDING_DEFAULT)
            .clickable { onClick.invoke() },
    ) {
        Row {
            Image(
                modifier = Modifier
                    .size(75.dp)
                    .align(Alignment.CenterVertically)
                    .padding(COMMON_PADDING_MIN),
                painter = painterResource(icon),
                contentDescription = null,
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(COMMON_PADDING_MIN),
                text = title,
                fontSize = 15.sp,
                fontWeight = Bold
            )
        }
    }
}