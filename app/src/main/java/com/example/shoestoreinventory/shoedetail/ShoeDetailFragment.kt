package com.example.shoestoreinventory.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestoreinventory.datastore.Shoe
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.ShoeList.ShoeListViewModel
import com.example.shoestoreinventory.databinding.FragmentShoeDetailBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {

    private lateinit var shoeDetailBinding: FragmentShoeDetailBinding
    private val shoeListViewModel by activityViewModels<ShoeListViewModel>()
    private  val shoe = Shoe()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        shoeDetailBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)
        shoeDetailBinding.shoeObject = shoe
        shoeDetailBinding.shoeDetailFragment = this
        setHasOptionsMenu(true)
        return shoeDetailBinding.root
    }

    fun saveShoe(){
        shoeListViewModel.addShoe(shoe)
        findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }

    fun showShoeListScreen(){
        findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.app_logout).isVisible = false
    }

}