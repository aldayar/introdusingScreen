package com.example.lesson2.ui.fragments.code

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentCodeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider

class CodeFragment : BaseFragment<FragmentCodeBinding>(FragmentCodeBinding::inflate) {

    lateinit var id: String
    lateinit var mAuth : FirebaseAuth

    override fun setupUI() {
        mAuth = FirebaseAuth.getInstance()
        if (arguments != null) {
            id = arguments?.getString("id").toString()
        }
    }

    override fun setAnim() {

    }

    override fun setupObserver() {
        binding.btnInit.setOnClickListener {
            val code = binding.edPhone.text.toString()
            val credential = PhoneAuthProvider.getCredential(id, code)
            mAuth.signInWithCredential(credential).addOnCompleteListener {
                if (it.isSuccessful) {
                    findNavController().navigate(R.id.noteFragment)
                } else {
                    Log.e("ololo", it.exception?.message.toString())
                }
            }
        }
    }
}