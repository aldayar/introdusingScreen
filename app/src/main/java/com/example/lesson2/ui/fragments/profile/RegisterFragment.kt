package com.example.lesson2.ui.fragments.profile


import android.util.Log
import androidx.navigation.fragment.findNavController
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentRegisterBinding
import com.example.lesson2.ui.activity.App


class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    override fun setupUI() {
        saveBtnListener()

    }

    private fun saveBtnListener() {
        binding.btnSaveUserMod.setOnClickListener{
            App.prefs.saveUserMod()
            saveUserMod()
            findNavController().navigate(R.id.profile_note_fragment)
        }
    }

    private fun saveUserMod() {

        val name = binding.etName.text.toString()
        App.prefs.saveUserName(name)
        val surName = binding.etSurName.text.toString()
        App.prefs.saveSurUserName(surName)
        val number = binding.etNumber.text.toString()
        if (number.isNotEmpty()) {
            try {
                val numberInt = number.toInt()
                App.prefs.saveUserPhone(numberInt)
            } catch (e: NumberFormatException) {
                Log.e("ololo", "Exception: ${e.message}")
            }
        } else {
            Log.e("ololo", "Number is empty")
        }

        binding.smMerried.setOnCheckedChangeListener { _, isChecked ->
            if (App.prefs.isUserMarried(isChecked)) {
                binding.smMerried.setText("Married")
            } else {
                binding.smMerried.setText("Not married")
            }
        }



    }
}
