package com.dreamcoder.questionlessonapp.util

sealed class Routes(val route:String) {
    object QuestionScreen : Routes("QuestionScreen")
    object ResultScreen : Routes("ResultScreen")
}