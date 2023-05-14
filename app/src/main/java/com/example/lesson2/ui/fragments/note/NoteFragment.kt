package com.example.lesson2.ui.fragments.note

import androidx.navigation.fragment.findNavController
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentNoteBinding

class NoteFragment : BaseFragment<FragmentNoteBinding>(FragmentNoteBinding::inflate) {

    override fun setupUI() {
        binding.itemBtnNext.setOnClickListener{
            findNavController().navigate(R.id.addNoteFragment)
        }

    }

    override fun setupObserver() {
    }
}