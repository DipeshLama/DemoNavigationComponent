package com.example.navigationcomponent.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.R
import com.example.navigationcomponent.databinding.FragmentLoginBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginFragment : Fragment(), View.OnClickListener {
    private lateinit var binding : FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.findViewById<BottomNavigationView>(R.id.btmNav)?.visibility =View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        initListener()
    }

    private fun initListener (){
        binding.btnLogin.setOnClickListener(this)
        binding.txvNavigateToSignUp.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view ){
            binding.btnLogin -> {
                navigateToHome()
            }
            binding.txvNavigateToSignUp ->{
                navigateToSignUp()
            }
        }
    }

    private fun navigateToSignUp(){
        findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
    }

    private fun navigateToHome (){
        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.findViewById<BottomNavigationView>(R.id.btmNav)?.visibility = View.VISIBLE
    }
}