package com.dreamcoder.questionlessonapp.navigation

import QuestionViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dreamcoder.questionlessonapp.ui.theme.screen.QuestionScreen
import com.dreamcoder.questionlessonapp.ui.theme.screen.ResultScreen

@Composable
fun Navigation(quizViewModel: QuestionViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.QuestionScreen.route) {
        composable(Routes.QuestionScreen.route) {
            QuestionScreen(quizViewModel, navController)
        }
        composable(Routes.ResultScreen.route) {
            ResultScreen(navController)
        }
    }
}