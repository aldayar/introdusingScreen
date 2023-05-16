package com.example.lesson2.ui.fragments.board

import androidx.navigation.fragment.findNavController
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentOnBoardBinding
import com.example.lesson2.ui.activity.App
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator


class OnBoardFragment : BaseFragment<FragmentOnBoardBinding>(FragmentOnBoardBinding::inflate){
    private lateinit var dotsIndicator: DotsIndicator

        private val adapter:BoardAdapter by lazy { BoardAdapter(this::listener,this::skip) }
    override fun setupUI() {
        binding.pager.adapter = adapter

        dotsIndicator =binding.dotsIndicator
        dotsIndicator.setViewPager2(binding.pager)

    }

    override fun setAnim() {null}
    private fun listener(){
        App.prefs.saveBoardState()
        findNavController().navigate(R.id.noteFragment)
    }
    private fun skip() {
        App.prefs.saveBoardState()
        findNavController().navigate(R.id.noteFragment)
    }
}