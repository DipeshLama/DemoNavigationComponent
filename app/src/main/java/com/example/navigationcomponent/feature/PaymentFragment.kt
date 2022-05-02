package com.example.navigationcomponent.feature

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponent.R
import com.example.navigationcomponent.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {
    private lateinit var binding : FragmentPaymentBinding
    private val args : PaymentFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPaymentBinding.bind(view)
        setData()
    }

    @SuppressLint("SetTextI18n")
    private fun setData (){
        binding.txvAccountName.text = "Account Name : ${args.accountName}"
        binding.txvAccountNumber.text = "Account Number : ${args.accountNumber}"
        binding.txvBankName.text = "Bank Name${args.bank}"
        binding.txvAmount.text = " Amount : ${args.amount}"
    }
}