package com.dreamcoder.questionlessonapp.viewModel

import com.dreamcoder.questionlessonapp.Repository.QuestionRepo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dreamcoder.questionlessonapp.model.QuestionModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuestionViewModel(private val repository: QuestionRepo) : ViewModel() {

    private val _questions = MutableStateFlow<List<QuestionModel>>(emptyList())
    val questions: StateFlow<List<QuestionModel>> = _questions

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        loadQuestions()
    }

    private fun loadQuestions() {
        viewModelScope.launch {
            repository.getAllQuestions { question ->
                _questions.value = question
                _isLoading.value = false
            }
        }
    }

    fun selectOption(questionId: Int, option: String) {
        _questions.value = _questions.value.map { question ->
            if (question.id == questionId) {
                question.copy(selectedOption = option)
            } else {
                question
            }
        }
    }

    fun addComment(questionId: Int, comment: String) {
        _questions.value = _questions.value.map { question ->
            if (question.id == questionId) {
                question.copy(userComment = comment)
            } else {
                question
            }
        }
    }

    fun resQuestion(){
        _questions.value = emptyList()
        loadQuestions()
    }
}
