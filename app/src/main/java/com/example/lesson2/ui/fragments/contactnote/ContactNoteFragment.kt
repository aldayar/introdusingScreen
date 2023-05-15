package com.example.lesson2.ui.fragments.contactnote

import androidx.navigation.fragment.findNavController
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentContactBinding


class ContactNoteFragment : BaseFragment<FragmentContactBinding>(FragmentContactBinding::inflate) {
    override fun setupUI() {
        binding.itemLtBoard.setAnimation(R.raw.contact)
        binding.itemLtBoard.playAnimation()
    }

}