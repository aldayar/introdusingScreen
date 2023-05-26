package com.example.lesson2.ui.fragments.init

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentPhoneBinding
import com.example.lesson2.ui.activity.MainActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class PhoneFragment : BaseFragment<FragmentPhoneBinding>(FragmentPhoneBinding::inflate) {


    private lateinit var mAuth: FirebaseAuth
    lateinit var phone: String
    lateinit var callback: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun setupUI() {
        mAuth = FirebaseAuth.getInstance()
    }



    override fun setupObserver() {
        binding.btnInit.setOnClickListener {
            phone = binding.edPhone.text.toString()
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone, 60, TimeUnit.SECONDS,
                activity as MainActivity, callback
            )
            Log.e("ololo1", "hello")
        }
        callback = object: PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                mAuth.signInWithCredential(credential).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(requireContext(), "Welcome to app", Toast.LENGTH_SHORT).show()
                        findNavController().navigateUp()
                    } else {
                        Log.e("ololo", task.exception?.message.toString())
                    }
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(requireContext(), "Your entered phone number invalid, please check and try again", Toast.LENGTH_SHORT).show()
                Log.e("ololo", p0.message.toString())
            }

            override fun onCodeSent(id: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(id, p1)
                val bundle = Bundle()
                bundle.putString("id", id)
                findNavController().navigate(R.id.codeFragment, bundle)
            }
        }
    }

}