package com.dreamcoder.questionlessonapp.ui.theme.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomBorderText(
    title: String,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .border(
                width = 0.8.dp,
                color = Color.Black,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(start = 8.dp, end = 8.dp, top = 5.dp, bottom = 5.dp),
    ) {
        BasicText(
            text = title,
            style = MaterialTheme.typography.bodySmall.copy(
                color = Color.Black
            )
        )
    }
}