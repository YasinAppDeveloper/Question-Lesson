@file:Suppress("VARIABLE_WITH_REDUNDANT_INITIALIZER", "UnusedImport")

package com.dreamcoder.questionlessonapp.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dreamcoder.questionlessonapp.common.CustomSpacer
import com.dreamcoder.questionlessonapp.common.CustomText
import com.dreamcoder.questionlessonapp.common.MainTopBar
import com.dreamcoder.questionlessonapp.common.UserInfoBox
import com.dreamcoder.questionlessonapp.model.QuestionModel
import com.dreamcoder.questionlessonapp.navigation.Routes
import com.dreamcoder.questionlessonapp.viewModel.QuestionViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun QuestionScreen(
    viewModel: QuestionViewModel, navController: NavController
) {

    val questions by viewModel.questions.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    var count = 0

    Box(
        modifier = Modifier
            .padding(bottom = 10.dp, top = 20.dp)
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        if (isLoading) {
            Text(
                text = "Loading...",
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn {

                item {
                    MainTopBar()
                    CustomSpacer(dp = 1.dp, modifier = Modifier.background(color = Color.Black))
                    UserInfoBox()
                    CustomSpacer(dp = 1.dp, modifier = Modifier.background(color = Color.Black))
                }

                itemsIndexed(questions) { index, question ->
                    count = index + 1
                    QuestionItem(
                        count,
                        question,
                        onOptionSelected = { option ->
                            viewModel.selectOption(question.id, option)
                        },
                        onCommentAdded = {
                            viewModel.addComment(question.id, it)
                        }
                    )
                }
            }

            FloatingActionButton(
                onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        "questions",
                        questions
                    )
                    navController.navigate(Routes.ResultScreen.route)

                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Check")
            }

        }

    }

}

@Composable
fun QuestionItem(
    number: Int,
    question: QuestionModel,
    onOptionSelected: (String) -> Unit,
    onCommentAdded: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(top = 14.dp)
            .fillMaxHeight()
            .background(color = Color.White)
    ) {

        CustomText(
            title = "$number. ${question.question}",
            fontFamily = FontFamily.SansSerif,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 10.dp)
        )

        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            question.options.forEach { option ->
                Row(
                    modifier = Modifier.padding(end = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = question.selectedOption == option,
                        onClick = { onOptionSelected(option) },
                    )
                    Text(text = option, fontSize = 13.sp)
                }
            }
        }

        var userComment by remember { mutableStateOf(question.userComment) }
        OutlinedTextField(
            value = userComment!!,
            onValueChange = { newComment ->
                userComment = newComment
                onCommentAdded(newComment)
            },
            label = { Text("Enter your comment") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )
    }
}
