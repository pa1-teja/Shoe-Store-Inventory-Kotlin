package com.example.shoestoreinventory.ShoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.FragmentShoeListBinding
import com.example.shoestoreinventory.databinding.ItemShoeBinding
import com.example.shoestoreinventory.datastore.Shoe
import kotlinx.android.synthetic.main.item_shoe.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {


    private val shoeListViewModel by activityViewModels<ShoeListViewModel>()
    private lateinit var shoeListBinding: FragmentShoeListBinding
    private lateinit var shoeItemShoeBinding: ItemShoeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        shoeListBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)
        shoeListBinding.setLifecycleOwner(this)
        shoeListViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoes ->
            shoes.forEach{addShoeToShoeListUI(it)}
        })
        shoeListBinding.shoeDetailBtn.setOnClickListener(Navigation.createNavigateOnClickListener(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()))
        return shoeListBinding.root
    }

    private fun addShoeToShoeListUI(shoe: Shoe) {
        shoeItemShoeBinding = DataBindingUtil.inflate<ItemShoeBinding>(layoutInflater,R.layout.item_shoe,shoeListBinding.shoeListLinearLayout,false)

        shoeItemShoeBinding.shoeNameTv.text = shoe.shoeName ?: ""
        shoeItemShoeBinding.shoeCompanyTv.text = shoe.shoeCompanyName ?: ""
        shoeItemShoeBinding.shoeSizeTv.text = shoe.shoeSize ?:""
        shoeItemShoeBinding.shoeDescriptionTv.text = shoe.shoeDescription ?:""

        shoeListBinding.shoeListLinearLayout.addView(shoeItemShoeBinding.root)
    }

}