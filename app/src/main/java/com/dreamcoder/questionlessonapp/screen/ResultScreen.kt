package com.dreamcoder.questionlessonapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dreamcoder.questionlessonapp.model.QuestionModel
import com.dreamcoder.questionlessonapp.util.Routes
import com.dreamcoder.questionlessonapp.components.CustomBorderText
import com.dreamcoder.questionlessonapp.components.CustomSpacer
import com.dreamcoder.questionlessonapp.components.CustomText
import com.dreamcoder.questionlessonapp.components.ResultScreenSecondToolbar
import com.dreamcoder.questionlessonapp.components.ResultScreenToolbar
import com.dreamcoder.questionlessonapp.viewModel.QuestionViewModel

@Composable
fun ResultScreen(navController: NavController, viewModel: QuestionViewModel,) {
    val questions =
        navController.previousBackStackEntry?.savedStateHandle?.get<List<QuestionModel>>("questions")

    Box(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        LazyColumn {
            item {
                ResultScreenToolbar {
                    navController.navigate(Routes.QuestionScreen.route){
                        popUpTo(navController.graph.id)
                        launchSingleTop = true
                        viewModel.resQuestion()
                    }
                }
                CustomSpacer(dp = 1.dp, modifier = Modifier.background(color = Color.Black))
                ResultScreenSecondToolbar()
                CustomSpacer(dp = 1.dp, modifier = Modifier.background(color = Color.Black))
            }
            if (questions != null) {
                items(questions) { question ->
                    ResultItem(question = question)
                }
            }
        }
    }
}

@Composable
fun ResultItem(question: QuestionModel) {

    Column()
    {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
        ) {
            CustomText(
                title = question.question,
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(start = 10.dp, top = 4.dp)
            )
            if (question.selectedOption!!.isNotEmpty()) {
                CustomText(
                    title = question.selectedOption,
                    fontSize = 11.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }
        CustomSpacer(dp = 5.dp, modifier = Modifier)
        if (question.userComment!!.isNotEmpty()) {
            CustomBorderText(
                title = question.userComment,
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            )
        }
    }
}