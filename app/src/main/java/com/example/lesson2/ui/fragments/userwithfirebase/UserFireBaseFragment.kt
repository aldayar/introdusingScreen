package com.example.lesson2.ui.fragments.userwithfirebase
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.lesson2.R
import com.example.lesson2.base.BaseFragment
import com.example.lesson2.databinding.FragmentUserFireBaseBinding
import com.example.lesson2.ui.activity.App
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class UserFireBaseFragment : BaseFragment<FragmentUserFireBaseBinding>(FragmentUserFireBaseBinding::inflate) {
    private lateinit var database: DatabaseReference
    override fun setupUI() {

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Save profile!")
        builder.setMessage("To protect your profile, please log to cloud to safe data")
        builder.setPositiveButton("Ok",null)
        builder.setNegativeButton("later"){_,_->
            findNavController().navigateUp()
        }
        builder.show()
        setAnim()
        setUpUI()
        getText()
    }

    private fun setAnim(){
        binding.animation.setAnimation(R.raw.sunset)
    }
    private fun setUpUI(){
        val toolbar: Toolbar = binding.toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    private fun getText()= with(binding) {
        regBtn.setOnClickListener {
            App.prefs.saveRegByFireBase()
            if (nameUserEt.text.toString().isEmpty()){
                nameUserEt.error = "Please fill the field, and try again"
            }
            if ( surnameUserEt.text.toString().isEmpty()) {
                surnameUserEt.error = "Please fill the field, and try again"
            }
            if ( ageUserEt.text.toString().isEmpty()){
                ageUserEt.error = "Please fill the field, and try again"
            } else {

                val userName = nameUserEt.text.toString()
                val userSurName = surnameUserEt.text.toString()
                val userAge = ageUserEt.text.toString()

                database = FirebaseDatabase.getInstance().getReference("Users")
                val user = UserModel(userName, userSurName, userAge)
                database.child(userName).setValue(user).addOnSuccessListener {
                    nameUserEt.text.clear()
                    surnameUserEt.text.clear()
                    ageUserEt.text.clear()
                    Toast.makeText(requireContext(), "Registered", Toast.LENGTH_SHORT).show()
                    findNavController().navigateUp()
                }
            }
        }
    }
}
