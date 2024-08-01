package com.dreamcoder.questionlessonapp.mvvm.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.dreamcoder.questionlessonapp.mvvm.Repository.QuestionRepository
import com.dreamcoder.questionlessonapp.mvvm.viewModel.QuestionViewModel

class QuizViewModelFactory(private val repository: QuestionRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(QuestionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuestionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

