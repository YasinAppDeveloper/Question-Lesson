import com.dreamcoder.questionlessonapp.data.QuestionModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    fun getAllQuestions(onComplete: (List<QuestionModel>) -> Unit) {
        firestore.collection("questions")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val result = task.result?.documents?.mapNotNull { it.toObject(QuestionModel::class.java) } ?: emptyList()
                    onComplete(result)
                } else {
                    onComplete(emptyList())
                }
            }
    }
}
