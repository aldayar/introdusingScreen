package com.example.lesson2.ui.fragments.profile

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentProfileNoteBinding
import com.example.lesson2.ui.activity.App

class ProfileFragment : BaseFragment<FragmentProfileNoteBinding>(FragmentProfileNoteBinding::inflate) {

    override fun setupUI() {
        showRegisterFragment()
        setTextFromSharedPref()
        binding.tvUserChecker.text = App.prefs.getUserMarried().toString()
        logOut()
    }
    private fun logOut(){
        binding.btnLogOut.setOnClickListener{
            App.prefs.logOut()
        }
    }
    private fun showRegisterFragment(){
        if (App.prefs.getUserName().isEmpty()&& App.prefs.getSurUserName().isEmpty()){
            Toast.makeText(requireContext(), "Please log again", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.registerFragment)
        }else{
            Toast.makeText(requireContext(), "Your profile", Toast.LENGTH_SHORT).show()
        }
    }
    private fun setTextFromSharedPref(){
        binding.tvUserName.text = App.prefs.getUserName()
        binding.tvUserSurname.text = App.prefs.getSurUserName()
        binding.tvUserNumber.text = App.prefs.getUserNumber().toString()
    }



}