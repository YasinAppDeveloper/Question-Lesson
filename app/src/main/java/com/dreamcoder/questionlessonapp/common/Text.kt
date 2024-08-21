package com.dreamcoder.questionlessonapp.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun CustomText(
    title:String,
    fontFamily: FontFamily,
    fontSize: TextUnit,
    color: Color,
    fontWeight: FontWeight,
    modifier: Modifier
) {

    Text(
        text = title,
        fontSize = fontSize,
        color = color,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        modifier = modifier
        )

}