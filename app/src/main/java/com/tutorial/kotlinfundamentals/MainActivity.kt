package com.tutorial.kotlinfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceRoller.setOnClickListener {
            val intent = Intent(this, DiceRollerActivity::class.java)
            startActivity(intent)
        }

        colorMyViews.setOnClickListener {
            val intent = Intent(this, ColorMyViewsActivity::class.java)
            startActivity(intent)
        }

        aboutMe.setOnClickListener {
            val intent = Intent(this, AboutMeActivity::class.java)
            startActivity(intent)
        }
    }
}
