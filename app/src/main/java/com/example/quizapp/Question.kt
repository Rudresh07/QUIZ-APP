package com.example.quizapp

data class Question(
    val id: Int,
    val question: String,
    val image: Int,

    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,

    val correctAns: Int
// now to access these questions we need to have another object of type object
//called constant where we store all our constants i.e. username, amount of questions , correct answers e.t.c
    )
