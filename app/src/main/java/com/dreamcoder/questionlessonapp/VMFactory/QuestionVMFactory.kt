package com.dreamcoder.questionlessonapp.VMFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.dreamcoder.questionlessonapp.Repository.QuestionRepo
import com.dreamcoder.questionlessonapp.viewModel.QuestionViewModel

class QuestionVMFactory(private val repository: QuestionRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(QuestionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuestionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

