package com.example.navigationcomponent.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.R
import com.example.navigationcomponent.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        initListener()
    }

    private fun initListener (){
        binding.btnSend.setOnClickListener(this)
    }

    private fun navigateToPayment(){
        val accountName = binding.edtAccountName.text.toString()
        val accountNumber = binding.edtAccountNumber.text.toString()
        val bankName = binding.edtBankName.text.toString()
        val amount = binding.edtAmount.text.toString().toInt()
        val action = HomeFragmentDirections.actionHomeFragmentToPaymentFragment(accountName,accountNumber,bankName,amount)
        findNavController().navigate(action)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnSend ->{
                navigateToPayment()
            }
        }
    }
}