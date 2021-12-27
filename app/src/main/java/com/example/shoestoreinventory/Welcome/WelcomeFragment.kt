package com.example.shoestoreinventory.Welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.FragmentWelcomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {

    private lateinit var welcomeBinding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        welcomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome,container,false)
        welcomeBinding.nextBtn.setOnClickListener(Navigation.createNavigateOnClickListener(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()))
        setHasOptionsMenu(true)
        return welcomeBinding.root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.app_logout).isVisible = false
    }
}