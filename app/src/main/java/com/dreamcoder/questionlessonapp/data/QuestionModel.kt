package com.dreamcoder.questionlessonapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuestionModel(
    val id:Int,
    val question:String,
    val options:List<String>,
    val selectedOption:String?=null,
    val userComment:String?=null
) : Parcelable {
    constructor() : this(0,"", listOf(),"","")
}
