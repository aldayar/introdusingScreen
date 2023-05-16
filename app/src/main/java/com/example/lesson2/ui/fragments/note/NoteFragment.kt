package com.example.lesson2.ui.fragments.note

import androidx.navigation.fragment.findNavController
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentNoteBinding

class NoteFragment : BaseFragment<FragmentNoteBinding>(FragmentNoteBinding::inflate) {

    override fun setupUI() {
        setAnim()
    }

    override fun setAnim() {
        binding.itemLtBoard.setAnimation(R.raw.note)
        binding.itemLtBoard.playAnimation()
    }


    override fun setupObserver() {
    }

}