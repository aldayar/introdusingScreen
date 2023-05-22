package com.example.lesson2.ui.fragments


import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentRegisterBinding
import com.example.lesson2.ui.activity.App


class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    override fun setupUI() {
      saveUserMod()
    }

    override fun setAnim() {
        null
    }
    private fun saveUserMod(){
        val name = binding.etName.text.toString()
        App.prefs.saveUserName(name)
        val surName = binding.etSurName.text.toString()
        App.prefs.saveSurUserName(surName)
        val number = binding.etNumber.text
        App.prefs.saveUserPhone(number as Int)
    }
}