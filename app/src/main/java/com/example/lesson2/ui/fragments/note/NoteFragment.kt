package com.example.lesson2.ui.fragments.note

import androidx.navigation.fragment.findNavController
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentNoteBinding
import com.example.lesson2.ui.activity.App

class NoteFragment : BaseFragment<FragmentNoteBinding>(FragmentNoteBinding::inflate) {
private val adapter: NoteAdapter by lazy { NoteAdapter() }

    override fun setupUI() {
        binding.recycler.adapter= adapter
        getNote()
        setAnim()
        toAddNote()
        getNote()
    }

    private fun getNote() {
        adapter.setList(App.db.getNoteDao().getAllNote())
    }

    override fun setAnim() {
        binding.itemLtBoard.setAnimation(R.raw.note)
        binding.itemLtBoard.playAnimation()
    }
    override fun setupObserver() {
    }
    private fun toAddNote(){
        binding.floatingActionBtn.setOnClickListener{
            findNavController().navigate(R.id.addNoteFragment)
        }
    }

}