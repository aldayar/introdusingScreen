package com.example.lesson2.ui.fragments.addnote

import androidx.navigation.fragment.findNavController
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentAddNoteBinding


class AddNoteFragment : BaseFragment<FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate) {
    override fun setupUI() {
        binding.itemBtnBack.setOnClickListener{
            findNavController().navigate(R.id.noteFragment)
        }
    }

}