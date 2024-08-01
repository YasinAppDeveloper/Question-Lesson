package com.dreamcoder.questionlessonapp.mvvm.Repository

import com.dreamcoder.questionlessonapp.model.QuestionModel
import com.google.firebase.firestore.FirebaseFirestore


class QuestionRepository (
    private val firestore: FirebaseFirestore
) {
    fun getAllQuestions(onComplete: (List<QuestionModel>) -> Unit) {
        firestore.collection("questions")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val result =
                        task.result?.documents?.mapNotNull { it.toObject(QuestionModel::class.java) }
                            ?: emptyList()
                    onComplete(result)
                } else {
                    onComplete(emptyList())
                }
            }
    }
}
