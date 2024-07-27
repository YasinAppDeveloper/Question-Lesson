package com.dreamcoder.questionlessonapp.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun CustomSpacer(dp: Dp,modifier: Modifier) {
    Spacer(
        modifier = modifier
            .fillMaxWidth()
            .height(dp)

    )
}