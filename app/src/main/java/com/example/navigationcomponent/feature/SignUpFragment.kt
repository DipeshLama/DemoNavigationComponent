package com.example.navigationcomponent.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.R
import com.example.navigationcomponent.databinding.FragmentSignUpBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class SignUpFragment : Fragment(), View.OnClickListener {
    private lateinit var binding : FragmentSignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)
        initListener()
    }

    private fun initListener(){
        binding.txvNavigateToLogin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view) {
            binding.txvNavigateToLogin ->{
                navigateToLogin()
            }
        }
    }

    private fun navigateToLogin(){
        findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
    }

}