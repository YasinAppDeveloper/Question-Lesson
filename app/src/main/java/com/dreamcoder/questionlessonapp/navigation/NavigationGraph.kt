package com.dreamcoder.questionlessonapp.navigation

import com.dreamcoder.questionlessonapp.viewModel.QuestionViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dreamcoder.questionlessonapp.screen.QuestionScreen
import com.dreamcoder.questionlessonapp.screen.ResultScreen
import com.dreamcoder.questionlessonapp.util.Routes

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