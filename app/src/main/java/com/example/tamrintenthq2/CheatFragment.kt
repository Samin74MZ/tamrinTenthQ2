package com.example.tamrintenthq2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tamrintenthq2.databinding.FragmentCheatBinding


class CheatFragment : Fragment() {
   lateinit var binding:FragmentCheatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCheatBinding.inflate(layoutInflater,container,false)
        return binding.root

    }


}