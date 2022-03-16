package com.example.tamrintenthq2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tamrintenthq2.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
    lateinit var binding:FragmentQuestionBinding
    val questionViewModel:QuestionModelView by viewModels()
    var listOfQuestion=QuestionModelView().qList
    var qNumber=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentQuestionBinding.inflate(layoutInflater,container,false)
        binding.textViewQ.text=listOfQuestion[qNumber].question
        if (qNumber==0){
            binding.buttonPrev.isEnabled=false
        }
        if (qNumber==9){
            binding.buttonNext.isEnabled=false
        }

        if (view==binding.buttonF){
            choseButton(binding.buttonF)
        }
        if (view==binding.buttonT){
            choseButton(binding.buttonT)
        }
        if (view==binding.buttonNext){
            choseButton(binding.buttonNext)
            updateQuestion(listOfQuestion[qNumber])
        }
        if (view==binding.buttonPrev){
            choseButton(binding.buttonPrev)
            updateQuestion(listOfQuestion[qNumber])
        }
        if (view==binding.buttonCheat) {
            initView()
        }
        return binding.root
    }


    private fun initView(){

        val action=QuestionFragmentDirections.actionQuestionFragmentToCheatFragment(listOfQuestion[qNumber].answer)
        findNavController().navigate(action)

    }
    private fun updateQuestion(question: Question) {
        binding.textViewQ.text=question.question
    }
    fun choseButton(view:View){
        if (view==binding.buttonPrev){
            qNumber -= 1
            updateQuestion(listOfQuestion[qNumber])
            binding.buttonT.isEnabled=true
            binding.buttonF.isEnabled=true
            binding.buttonNext.isEnabled=true
            if (qNumber==0){
                binding.buttonPrev.isEnabled=false
            }
        }
        if (view==binding.buttonNext){
            qNumber += 1
            updateQuestion(listOfQuestion[qNumber])
            binding.buttonT.isEnabled=true
            binding.buttonF.isEnabled=true
            binding.buttonPrev.isEnabled=true
            if (qNumber==9){
                binding.buttonNext.isEnabled=false
            }
        }
        if (view==binding.buttonCheat){
            initView()
            listOfQuestion[qNumber].cheat=true
        }
        if (view==binding.buttonF){
            if (binding.buttonF.text.toString().lowercase()==listOfQuestion[qNumber].answer.toString()){
                if (listOfQuestion[qNumber].cheat){
                    Toast.makeText(context,"Cheating is wrong!", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context,"Correct!", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(context,"Incorrect!", Toast.LENGTH_SHORT).show()
            }
            binding.buttonT.isEnabled=false
            view.isEnabled=false

        }
        if (view==binding.buttonT){
            if (binding.buttonT.text.toString().lowercase()==listOfQuestion[qNumber].answer.toString()){
                if (listOfQuestion[qNumber].cheat){
                    Toast.makeText(context,"Cheating is wrong!", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context,"Correct!", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(context,"Incorrect!", Toast.LENGTH_SHORT).show()
            }
            view.isEnabled=false
            binding.buttonF.isEnabled=false
        }
    }

}