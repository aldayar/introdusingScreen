package com.example.lesson2.ui.fragments.profile

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentProfileNoteBinding
import com.example.lesson2.ui.activity.App
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfileFragment : BaseFragment<FragmentProfileNoteBinding>(FragmentProfileNoteBinding::inflate) {

    override fun setupUI() {

        showRegisterFragment()
        setTextFromSharedPref()
        logOut()
    }
    private fun logOut(){
        val  btnLogOutUser: FloatingActionButton = requireView().findViewById(R.id._btn_log_out_user)
        btnLogOutUser.setOnClickListener {
            App.prefs.logOut(requireActivity())
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

        binding.tvUserChecker.text = App.prefs.getUserMarried().toString()
        binding.tvUserName.text = App.prefs.getUserName()
        binding.tvUserSurname.text = App.prefs.getSurUserName()
        binding.tvUserNumber.text = App.prefs.getUserNumber().toString()
    }



}