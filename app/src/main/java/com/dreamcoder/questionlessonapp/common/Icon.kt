package com.dreamcoder.questionlessonapp.common

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.dreamcoder.questionlessonapp.R

@Composable
fun Icon(
    @DrawableRes icon : Int,
    modifier: Modifier
) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = stringResource(id = R.string.icon),
        modifier = modifier
    )
}