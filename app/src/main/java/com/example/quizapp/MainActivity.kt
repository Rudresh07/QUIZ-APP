package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager.LayoutParams.*
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btn_start)
        val etName : EditText = findViewById(R.id.name)
        btnStart.setOnClickListener {

            if(etName.text.isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, Quiz_Question_Activity :: class.java)
                //this intent allow me to move us from the current activity to the desired activity in this case it is Quiz_Question_Activity
                //for that first we pass the context from where to where and which type of class the file contain.

                //this is not enough to goto next screen we also have to start the intent to move to other screen too.

    //putExtra is use to send some data when intent is clicked i.e. start activity take place
                intent.putExtra(Constant.USER_NAME, etName.text.toString())

                startActivity(intent)
                //the above code will start the new screen but doesn't close the previous screen for that we need follow the below steps

                finish()//this will finish the main activity



                //now we will setup all our questions in another class name question of datatype class
            }
        }

    }
}