package com.dreamcoder.questionlessonapp.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dreamcoder.questionlessonapp.R


@Composable
@Preview
fun QuizScreenSecondToolbar(
) {
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .padding(10.dp)
    ) {

        CustomText(
            title = stringResource(id = R.string.user_name),
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
        )

        CustomSpacer(dp = 5.dp, modifier = Modifier)

        CustomText(
            title = stringResource(id = R.string.lesson_main),
            fontFamily = FontFamily.SansSerif,
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
        )

        CustomSpacer(dp = 10.dp, modifier = Modifier)

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            CustomText(
                title = stringResource(id = R.string.start_time),
                fontFamily = FontFamily.SansSerif,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
            )

            CustomBorderText(
                title = stringResource(id = R.string.start_lesson),
                modifier = Modifier
            )
        }

    }
}