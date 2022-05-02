package com.example.navigationcomponent.feature

import android.app.Notification
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.R
import com.example.navigationcomponent.databinding.FragmentHomeBinding
import com.example.navigationcomponent.notificationchannel.AppNotification
import kotlin.time.Duration.Companion.milliseconds

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding : FragmentHomeBinding
    private lateinit var accountName : String
    private lateinit var accountNumber : String
    private lateinit var bankName : String
    private var amount : Int? = null

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
        binding.btnExplict.setOnClickListener(this)
    }

    private fun navigateToPayment(){
        setInputValues()
        if (isValid()){
            val action = HomeFragmentDirections.actionHomeFragmentToPaymentFragment(accountName,accountNumber,bankName,
                amount!!)
            findNavController().navigate(action)
        }else{
            Toast.makeText(context, "Please enter all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendNotification(){
        setInputValues()
        val pendingIntent = findNavController()
            .createDeepLink()
            .setDestination(R.id.paymentFragment)
            .setGraph(R.navigation.nav_graph)
            .setArguments(PaymentFragmentArgs(accountName,accountNumber,bankName, amount!!).toBundle())
            .createPendingIntent()

        val notificationManager =NotificationManagerCompat.from(requireContext())
        val notification : Notification = NotificationCompat.Builder(requireContext(),AppNotification().channel_1)
            .setContentTitle("Payment Success")
            .setContentText("Recipient: $accountName")
            .setSmallIcon(R.drawable.ic_home)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .build()
        notificationManager.notify(1, notification)
    }

    private fun setInputValues (){
        accountName = binding.edtAccountName.text.toString()
        accountNumber = binding.edtAccountNumber.text.toString()
        bankName = binding.edtBankName.text.toString()
        amount = binding.edtAmount.text.toString().toInt()
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnSend ->{
                navigateToPayment()
            }

            binding.btnExplict ->{
                sendNotification()
            }
        }
    }

    private fun isValid() : Boolean{
        when{
            accountName.isEmpty() && accountNumber.isEmpty() && bankName.isEmpty() && amount.toString().isEmpty() ->{
                return false
            }
        }
        return true
    }
}