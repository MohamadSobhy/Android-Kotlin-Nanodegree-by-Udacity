package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName = MyName(name = "Mohammad Sobhy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.doneButton.setOnClickListener {
            getNicknameAndHideField(it)
        }
    }

    private fun getNicknameAndHideField(view: View){
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

        val nickname = binding.nicknameField.text.trim()

        with(binding){
            if(nickname.isNotEmpty()){
                nicknameText.text = nickname
                invalidateAll()

                nicknameField.visibility = View.GONE
                nicknameText.visibility = View.VISIBLE
                view.visibility = View.GONE
            }else{
                nicknameField.error = "Nickname can't be empty"
            }
        }
    }
}