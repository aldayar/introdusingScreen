package com.example.lesson2.ui.fragments.note

import android.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.data.model.NoteModel
import com.example.lesson2.databinding.FragmentNoteBinding
import com.example.lesson2.ui.activity.App

class NoteFragment: BaseFragment<FragmentNoteBinding>(FragmentNoteBinding::inflate) {

    private val adapter: NoteAdapter by lazy { NoteAdapter(requireContext()) }
    override fun setupUI() {
        binding.recycler.adapter = adapter
        getNote()
        showText()
        toAddNote()
        getNote()
        sortItems()
    }

    private fun getNote() {
        adapter.setList(App.db.getNoteDao().getAllNote() as ArrayList<NoteModel>)
    }


    override fun setupObserver() {
        deleteNote()
    }

    private fun toAddNote() {
        binding.floatingActionBtn.setOnClickListener {
            findNavController().navigate(R.id.addNoteFragment)
        }
    }

    private fun deleteNote() {
        val simpleCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Warning")
                builder.setMessage("Do you want to delete the note?")
                builder.setPositiveButton("Yes") { _, _ ->
                    adapter.deleteNote(viewHolder.adapterPosition)
                    adapter.notifyItemRemoved(viewHolder.adapterPosition)
                }
                builder.setNegativeButton("No",null)
                builder.show()

            }

        }
        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(binding.recycler)
    }
    private fun showText(){
        if (adapter.itemCount==0) {
            binding.tvTitle.setText(R.string.title1)
        }else{
            binding.tvTitle.setText(R.string.title2)

        }
    }
    private fun sortItems(){
        binding.itemSortBtn.setOnClickListener{
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Sort by:")
            builder.setMessage("Do you want to sort by:")
            builder.setPositiveButton("Name") { _, _ ->
                App.db.getNoteDao().getSortedByTitle()
            }
            builder.setNeutralButton("Cancel",null)

            builder.setNegativeButton("Date"){_,_->
                App.db.getNoteDao().getSortedByDate()
            }
            builder.show()
        }
    }
}

