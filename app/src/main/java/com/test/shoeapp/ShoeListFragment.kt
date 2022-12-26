package com.test.shoeapp

import android.app.Activity
import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.shoeapp.databinding.FragmentInstructionsBinding
import com.test.shoeapp.databinding.FragmentShoeListBinding
import com.test.shoeapp.databinding.FragmentWelcomeBinding
import com.test.shoeapp.databinding.ItemShoeBinding

class ShoeListFragment() : Fragment() {

//    private val viewModel: SharedViewModel by activityViewModels()
    private val viewModel: ShoeViewModels by activityViewModels()

    companion object myList {
        val list = arrayListOf<Shoes>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater!!.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //get item id to handle item clicks
        val id = item!!.itemId
        //handle item clicks
        if (id == R.id.logout_menu){
            Navigation.findNavController(requireView()).navigate(R.id.action_shoeListFragment_to_loginFragment)
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val shoeListDatabinding: FragmentShoeListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        if ( viewModel.list.isEmpty())
        {
            val inflator : LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val dataBindingitem : ItemShoeBinding = DataBindingUtil.inflate(inflator,R.layout.item_shoe,shoeListDatabinding.linearAdding,false)
            dataBindingitem.linearItemShoe.setVisibility(View.INVISIBLE)
            shoeListDatabinding.linearAdding.addView(dataBindingitem.root)
        }
        else
        {
            viewModel.list.forEachIndexed { i, e ->
                val inflator : LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val dataBindingitem : ItemShoeBinding = DataBindingUtil.inflate(inflator,R.layout.item_shoe,shoeListDatabinding.linearAdding,false)
                dataBindingitem.linearItemShoe.setVisibility(View.VISIBLE)
                dataBindingitem.shoes = viewModel.list.get(i)
                shoeListDatabinding.linearAdding.addView(dataBindingitem.root)
            }

        }

        shoeListDatabinding.btnAdd.setOnClickListener {
                view : View->
            Navigation.findNavController(view).navigate(R.id.action_shoeListFragment_to_addShoeFragment)
        }
        return shoeListDatabinding.root
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
    }
}