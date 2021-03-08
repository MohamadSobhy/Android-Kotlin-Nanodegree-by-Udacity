package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage: ImageView
    private lateinit var toastLayout: View
    private lateinit var toastText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.roll_button)
        diceImage = findViewById(R.id.dice_image)
        toastLayout = layoutInflater.inflate(R.layout.custom_toast, null)
        toastText = toastLayout.findViewById(R.id.toast_message)

        rollButton.setOnClickListener{
            rollDice()
        }
    }

    private fun rollDice(){
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = getDiceDrawableResource(randomInt)
        diceImage.setImageResource(drawableResource)

        toastText.text = "Dice Rolled"

        with(Toast(this)){
            view = toastLayout
            duration = Toast.LENGTH_SHORT
            show()
        }
    }

    private fun getDiceDrawableResource(randomInt: Int): Int {
        return when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}