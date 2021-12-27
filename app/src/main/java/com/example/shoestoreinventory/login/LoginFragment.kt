package com.example.shoestoreinventory.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.FragmentLoginBinding


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private lateinit var loginBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        loginBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        setHasOptionsMenu(true)
        loginBinding.signUpBtn.setOnClickListener(Navigation.createNavigateOnClickListener(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()))
        loginBinding.loginBtn.setOnClickListener(Navigation.createNavigateOnClickListener(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()))

        return loginBinding.root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.app_logout).isVisible = false
    }
}