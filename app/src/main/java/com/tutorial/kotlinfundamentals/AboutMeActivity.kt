package com.tutorial.kotlinfundamentals

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


/**
 * Main Activity of the AboutMe app.
 * This codelab demonstrates how to add:
 *     * Data binding between MainActivity and activity_main.xml. How to remove findViewById,
 *       and how to display data in views using the data binding object.
 * This is the starter app.
 */

class AboutMeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }
    }

    /**
     * Click handler for the Done button.
     */
    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
