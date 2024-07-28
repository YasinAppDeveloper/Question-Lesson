package com.dreamcoder.questionlessonapp.navigation

sealed class Routes(val route:String) {
    object QuestionScreen : Routes("QuestionScreen")
    object ResultScreen : Routes("ResultScreen")
}