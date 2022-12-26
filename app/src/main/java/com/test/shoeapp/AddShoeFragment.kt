package com.test.shoeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.test.shoeapp.ShoeListFragment.myList.list
import com.test.shoeapp.databinding.FragmentAddShoeBinding

class AddShoeFragment : Fragment() {

    //    private val viewModel: SharedViewModel by activityViewModels()
    private val viewModel: ShoeViewModels by activityViewModels()
    private lateinit var shoeItems: Shoes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val addShoeDatabinding: FragmentAddShoeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_shoe, container, false)
        shoeItems = Shoes("","","","")
        addShoeDatabinding.shoesInput = shoeItems
        addShoeDatabinding.btnSave.setOnClickListener { view: View ->
            addShoeDatabinding.apply {
                viewModel.list.add(
                    shoesInput!!
//                    Shoes(
//                        addShoeDatabinding.textEditShoeName.text.toString(),
//                        addShoeDatabinding.textEditShoeSize.text.toString(),
//                        addShoeDatabinding.textEditShoeCompany.text.toString(),
//                        addShoeDatabinding.textEditShoeDescription.text.toString()
//                    )
                )
                invalidateAll()
            }
            Navigation.findNavController(view).navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }



        return addShoeDatabinding.root
    }
}