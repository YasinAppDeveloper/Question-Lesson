@file:Suppress("UnusedImport")

package com.dreamcoder.questionlessonapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dreamcoder.questionlessonapp.R

@Composable
fun ResultScreenToolbar(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(color = Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            CustomIcon(
                icon = R.drawable.back_arrow,
                modifier = Modifier.clickable { onBackClick() }
                    .padding(start = 10.dp, top = 2.dp)
                    .size(20.dp)
            )
            CustomText(
                title = stringResource(id = R.string.back),
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
            )
        }

        CustomText(
            title = stringResource(id = R.string.lesson_detail),
            fontFamily = FontFamily.SansSerif,
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 2.dp)
        )

        Row {

            CustomBorderText(
                title = stringResource(id = R.string.share),
                modifier = Modifier.padding(end = 10.dp)
            )
        }

    }
}