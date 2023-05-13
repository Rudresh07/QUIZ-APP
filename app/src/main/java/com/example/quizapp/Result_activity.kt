package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.widget.Button
import android.widget.TextView

class Result_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val tvName:TextView = findViewById(R.id.tv_name)
        val tvScore:TextView = findViewById(R.id.tv_score)
        val finish:Button = findViewById(R.id.finish_btn)


        tvName.text = intent.getStringExtra(Constant.USER_NAME)

        val totalQuestions  = intent.getIntExtra(Constant.TOTAL_QUESTION, 0)
        val correctAnswer = intent.getIntExtra(Constant.CORRECT_ANS, 0)


        tvScore.text = "You scored $correctAnswer out of $totalQuestions"

        finish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }




    }
}