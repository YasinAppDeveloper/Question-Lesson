package com.dreamcoder.questionlessonapp.activity

import com.dreamcoder.questionlessonapp.Repository.QuestionRepository
import com.dreamcoder.questionlessonapp.viewModel.QuestionViewModel
import com.dreamcoder.questionlessonapp.ViewModelFactory.QuizViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.dreamcoder.questionlessonapp.navigation.Navigation
import com.dreamcoder.questionlessonapp.ui.theme.QuestionLessonAppTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.initialize


class MainActivity : ComponentActivity() {

    private lateinit var quizViewModel: QuestionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Firebase.initialize(this)
        val firestore = FirebaseFirestore.getInstance()
        val repository = QuestionRepository(firestore)
        val viewModelFactory = QuizViewModelFactory(repository)
        quizViewModel = ViewModelProvider(this, viewModelFactory)[QuestionViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            QuestionLessonAppTheme {
               Navigation(quizViewModel = quizViewModel)
            }
        }
    }
}

