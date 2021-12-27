package com.example.shoestoreinventory.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.FragmentInstructionsBinding


/**
 * A simple [Fragment] subclass.
 * Use the [InstructionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructionsFragment : Fragment() {

    private lateinit var instructionsBinding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        instructionsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_instructions,container,false)
        instructionsBinding.nextBtn.setOnClickListener(Navigation.createNavigateOnClickListener(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment2()))
        setHasOptionsMenu(true)
        return instructionsBinding.root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.app_logout).isVisible = false
    }
}