package com.dreamcoder.questionlessonapp.activity

import com.dreamcoder.questionlessonapp.Repository.QuestionRepo
import com.dreamcoder.questionlessonapp.viewModel.QuestionViewModel
import com.dreamcoder.questionlessonapp.VMFactory.QuestionVMFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.dreamcoder.questionlessonapp.navigation.NavGraph
import com.dreamcoder.questionlessonapp.ui.theme.QuestionLessonAppTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.initialize


class MainActivity : ComponentActivity() {

    private lateinit var questionViewModel: QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Firebase.initialize(this)

        val firestore = FirebaseFirestore.getInstance()
        val repository = QuestionRepo(firestore)

        val viewModelFactory = QuestionVMFactory(repository)
        questionViewModel = ViewModelProvider(this, viewModelFactory)[QuestionViewModel::class.java]

        setContent {
            QuestionLessonAppTheme {
               NavGraph(quizViewModel = questionViewModel)
            }
        }
    }
}

