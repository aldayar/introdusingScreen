package com.example.lesson2.ui.fragments.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.airbnb.lottie.LottieAnimationView
import com.example.lesson2.R
import com.example.lesson2.databinding.ItemBoardBinding

class BoardAdapter(private  var listener: ()-> Unit):Adapter<BoardAdapter.BoardViewHolder>() {
    private val animList= listOf(R.raw.note_anim,R.raw.note_anim_2,R.raw.note_anim_3)
   private val titleList = listOf("About app", "About us" , "How to use")
   private val desList = listOf("App was developed on kotlin", "About us is nothing known" , "Save what you want, and it will be save forever")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= BoardViewHolder(
        ItemBoardBinding.inflate(LayoutInflater.from(parent.context),parent,false)

    )
    override fun getItemCount()= titleList.size



    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        if (position < titleList.size && position < titleList.size && position < desList.size) {
            holder.onBind(position, titleList[position], desList[position],animList[position])
        }
    }

    inner class BoardViewHolder (private val binding: ItemBoardBinding):ViewHolder(binding.root) {
        fun onBind(position: Int, title: String, description: String,animationId:Int) {
//            binding.itemLtBoard.setImageResource(imgResId)
            val animationList: LottieAnimationView
            binding.itemLtBoard.setAnimation(animationId)
            binding.itemLtBoard.playAnimation()
            binding.itemTvTitle.text = title
            binding.itemTvDes.text = description


            binding.itemBtnNext.isEnabled = position == 2
            //недоступен до 3 позиции слайда

//            if (position != 2) {
//                binding.itemBtnNext.isEnabled = false
//            } else {
//                binding.itemBtnNext.isEnabled = true
//            }
            binding.itemBtnNext.setOnClickListener{
                listener.invoke()
            }

        }
    }

}