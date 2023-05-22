package com.example.lesson2.ui.fragments.board

import androidx.navigation.fragment.findNavController
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentOnBoardBinding
import com.example.lesson2.ui.activity.App
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit


class OnBoardFragment : BaseFragment<FragmentOnBoardBinding>(FragmentOnBoardBinding::inflate) {


    private val adapter: BoardAdapter by lazy { BoardAdapter(this::listener, this::skip) }

    override fun setupUI() {
        binding.pager.adapter = adapter
        tabIndicator()
    }
    override fun setAnim() {}

    private fun listener() {
        App.prefs.saveBoardState()
        findNavController().navigate(R.id.phoneFragment)
    }

    private fun skip() {
        App.prefs.saveBoardState()
        findNavController().navigate(R.id.noteFragment)
    }
    private fun tabIndicator(){
        TabLayoutMediator(binding.dotsIndicator,binding.pager){ tab, position->
            tab.setIcon(R.drawable.tab_indicator)
        }.attach()
    }
}