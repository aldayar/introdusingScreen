package com.example.lesson2.ui.fragments.profilenote

import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentProfileNoteBinding

class ProfileNoteFragment : BaseFragment<FragmentProfileNoteBinding>(FragmentProfileNoteBinding::inflate) {

    override fun setupUI() {
        setAnim()
    }

    override fun setAnim() {
        binding.itemLtBoard.setAnimation(R.raw.profile)
        binding.itemLtBoard.playAnimation()
    }

}