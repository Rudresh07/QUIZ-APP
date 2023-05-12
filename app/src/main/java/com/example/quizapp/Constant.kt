package com.example.quizapp

object Constant {


    const val USER_NAME : String = "User_name"
    const val TOTAL_QUESTION:String = "total_questions"
    const val CORRECT_ANS: String = "Correct_answers"

    fun getQuestion():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,"Name the country that the flag belong to",
            R.drawable.ic_india,
            "India","Australia","Pakistan","Brazil",
            1
        )

        questionList.add(question1)

        val question2 = Question(
            2,"Name the country that the flag belong to",
            R.drawable.ic_nepal,
            "India","Australia","Pakistan","Nepal",
            4
        )

        questionList.add(question2)

        val question3 = Question(
            3,"Name the country that the flag belong to",
            R.drawable.ic_vietnam,
            "Vietnam","Australia","Pakistan","Brazil",
            1
        )

        questionList.add(question3)

        val question4 = Question(
            4,"Name the country that the flag belong to",
            R.drawable.ic_france,
            "India","Australia","France","Brazil",
            3
        )

        questionList.add(question4)

        val question5 = Question(
            5,"Name the country that the flag belong to",
            R.drawable.ic_brazil,
            "India","Australia","Pakistan","Brazil",
            4
        )

        questionList.add(question5)

        val question6 = Question(
            6,"Name the country that the flag belong to",
            R.drawable.ic_japan,
            "India","Japan","Pakistan","Brazil",
            2
        )

        questionList.add(question6)

        val question7 = Question(
            7,"Name the country that the flag belong to",
            R.drawable.ic_aus,
            "India","Australia","Pakistan","Brazil",
            2
        )

        questionList.add(question7)

        val question8 = Question(
            8,"Name the country that the flag belong to",
            R.drawable.ic_lebnon,
            "Lebanon","Australia","Pakistan","Brazil",
            1
        )

        questionList.add(question8)

        val question9 = Question(
            9,"Name the country that the flag belong to",
            R.drawable.ic_belgium,
            "India","Australia","Belgium","Brazil",
            3
        )

        questionList.add(question9)

        val question10 = Question(
            10,"Name the country that the flag belong to",
            R.drawable.ic_chile,
            "India","Australia","Pakistan","Chile",
            4
        )

        questionList.add(question10)

        return questionList
    }
}