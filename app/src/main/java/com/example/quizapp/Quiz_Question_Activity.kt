package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.Constant.USER_NAME

class Quiz_Question_Activity : AppCompatActivity(), View.OnClickListener {

    private var mcurrentPosition  : Int = 1
    private var mquestionsList :ArrayList<Question>? = null
    private var mselectedOption : Int = 0


    private var progressBar: ProgressBar? = null
    private var tvprogress : TextView? = null
    private var tvQuestion: TextView? = null

    private var musername: String? = null
    private var mcorrectAnswer : Int =0

    private var ivimage : ImageView? = null
    private var tvoption1 : TextView? = null
    private var tvoption2 : TextView? = null
    private var tvoption3 : TextView? = null
    private var tvoption4 : TextView? = null
    private var submit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityquizquestion)

        //calling it from main activity intent in form of string
        musername = intent.getStringExtra(Constant.USER_NAME)

        //now to get all these stuff we use findViewById functionality to get the all the stuff so that we can use them further
        progressBar = findViewById(R.id.ProgressBar)
        tvprogress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tv1)
        ivimage = findViewById(R.id.iv1)
        tvoption1 = findViewById(R.id.Option1)
        tvoption2 = findViewById(R.id.Option2)
        tvoption3 = findViewById(R.id.Option3)
        tvoption4 = findViewById(R.id.Option4)
        submit = findViewById(R.id.submitBtn)

        tvoption1?.setOnClickListener(this)
        tvoption2?.setOnClickListener(this)
        tvoption3?.setOnClickListener(this)
        tvoption4?.setOnClickListener(this)
        submit?.setOnClickListener(this)
        //this mean that the class quizclass activity should be on onclicklistener and onclicklistener this should follow the overrided code i.i. onclick code
//i.e. onclick method that has been overridden

        mquestionsList = Constant.getQuestion()

        setQuestion()




    }

    private fun setQuestion() {

        defaultOptionView()
        val question: Question = mquestionsList!![mcurrentPosition - 1]
        ivimage?.setImageResource(question.image)//since we use as an int to save the image so we use image as resource
        progressBar?.progress = mcurrentPosition
        tvprogress?.text = "$mcurrentPosition/${progressBar?.max}"

        tvQuestion?.text = question.question
        tvoption1?.text = question.option1
        tvoption2?.text = question.option2
        tvoption3?.text = question.option3
        tvoption4?.text = question.option4

        if(mcurrentPosition == mquestionsList!!.size){
            submit?.text = "FINISH"
        }
        else{
            submit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvoption1?.let{
            options.add(0,it)
        }

        tvoption2?.let{
            options.add(1,it)
        }

        tvoption3?.let{
            options.add(2,it)
        }

        tvoption4?.let{
            options.add(3,it)
        }

        for(option in options){

            option.setTextColor(Color.parseColor("#000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum: Int){
        defaultOptionView()
        mselectedOption = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
       tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.Option1 -> {
                tvoption1?.let{
                    selectedOptionView(it,1)
                }
            }

            R.id.Option2 -> {
                tvoption2?.let{
                    selectedOptionView(it,2)
                }
            }

            R.id.Option3 -> {
                tvoption3?.let{
                    selectedOptionView(it,3)
                }
            }

            R.id.Option4 -> {
                tvoption4?.let{
                    selectedOptionView(it,4)
                }
            }

            R.id.submitBtn ->{
                if(mselectedOption == 0) {
                    mcurrentPosition++


                    when {
                        mcurrentPosition <= mquestionsList!!.size -> {
                            setQuestion()
                        }
                        else->{

                            val intent = Intent(this,Result_activity::class.java)
                            intent.putExtra(Constant.USER_NAME,musername)
                            intent.putExtra(Constant.CORRECT_ANS,mcorrectAnswer)
                            intent.putExtra(Constant.TOTAL_QUESTION,mquestionsList?.size)
                            startActivity(intent)
                            finish()

                        }
                    }
                }
                else{
                    val question = mquestionsList?.get(mcurrentPosition-1)
                    if (question!!.correctAns != mselectedOption){
                        answerView(mselectedOption, R.drawable.incorrect_option_border_bg)
                    }
                    else{
                        mcorrectAnswer++
                    }
                    answerView(question.correctAns, R.drawable.correct_option_border_bg)

                    if(mcurrentPosition == mquestionsList!!.size){
                        submit?.text = "FINISH"
                    }
                    else{
                        submit?.text = "NEXT QUESTION"
                    }

                    mselectedOption = 0

                }
                    }
        }
    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){

            1->{
                tvoption1?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            2->{
                tvoption2?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            3->{
                tvoption3?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            4->{
                tvoption4?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
}