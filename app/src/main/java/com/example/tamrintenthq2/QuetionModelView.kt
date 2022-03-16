package com.example.tamrintenthq2

import androidx.lifecycle.ViewModel

data class Question(var question: String, var answer: Boolean, var cheat: Boolean = false)
class QuestionModelView :ViewModel(){
    var qList = mutableListOf<Question>()
    var q1 = Question("Each natural number has at least two natural counters", false)
    var q2 = Question("From one point just a straight line goes on.", false)
    var q3 = Question("B M. two different prime numbers is one", true)
    var q4 = Question("The square is a formal form", true)
    var q5 =
        Question("TThe result of multiplication a negative number in a negative number is a positive number", true)
    var q6 =
        Question("The result of the sum of the number with its symmetrical is zero", true)
    var q7 = Question("A negative numerical product is negative in a positive number", true)
    var q8 = Question("Water is not from the combination of oxygen and hydrogen", false)
    var q9 = Question(" Any positive integer is larger than any integer negative", true)
    var q10 = Question("قرینه ی قرینه ی هر عدد با خودش برابر است", true)
    init {
        add()
    }
    private fun add() {
        qList.add(q1)
        qList.add(q2)
        qList.add(q3)
        qList.add(q4)
        qList.add(q5)
        qList.add(q6)
        qList.add(q7)
        qList.add(q8)
        qList.add(q9)
        qList.add(q10)
    }
}