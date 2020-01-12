package com.tutorial.kotlinfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class DiceRollerActivity : AppCompatActivity() {

    lateinit var dice1Image: ImageView
    lateinit var dice2Image: ImageView

    // lateinit - variable will be initialized somewhere in the class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        dice1Image = findViewById(R.id.dice1Image)
        dice2Image = findViewById(R.id.dice2Image)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        dice1Image.setImageResource(getRandomDiceImage())
        dice2Image.setImageResource(getRandomDiceImage())
    }

    private fun getRandomDiceImage() : Int {
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }

}
