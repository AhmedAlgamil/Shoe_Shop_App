package com.test.shoeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.test.shoeapp.databinding.FragmentInstructionsBinding
import com.test.shoeapp.databinding.FragmentWelcomeBinding

class InstructionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val instructionsDatabinding: FragmentInstructionsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        instructionsDatabinding.btnNextInstructions.setOnClickListener {
            view : View ->
            Navigation.findNavController(view).navigate(R.id.action_instructionFragment_to_shoeListFragment)
        }
        return instructionsDatabinding.root
    }
}