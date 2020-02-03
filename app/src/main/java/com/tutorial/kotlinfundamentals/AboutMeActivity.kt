package com.tutorial.kotlinfundamentals

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tutorial.kotlinfundamentals.databinding.ActivityAboutMeBinding
import com.tutorial.kotlinfundamentals.models.MyName


/**
 * Main Activity of the AboutMe app.
 * This codelab demonstrates how to add:
 *     * Data binding between MainActivity and activity_main.xml. How to remove findViewById,
 *       and how to display data in views using the data binding object.
 * This is the starter app.
 */

class AboutMeActivity : AppCompatActivity() {

//    The name is derived from the name of the layout file, that is, activity_about_me + Binding.
    private lateinit var binding: ActivityAboutMeBinding

    private val myName: MyName = MyName("Hannah Banana")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       /* Next, you replace the current setContentView() function with an instruction
       that does the following:
        - Creates the binding object.
        - Uses the setContentView() function from the DataBindingUtil class to associate
        the activity_about_me layout with the AboutMeActivity. This setContentView() function also takes
        care of some data binding setup for the views.
        */

        //setContentView(R.layout.activity_about_me)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_about_me)

       /** When the binding object is created, the compiler generates the names of the views
        * in the binding object from the IDs of the views in the layout, converting them to camel case.
        * So, for example, done_button is doneButton in the binding object
        * */

//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
//        }

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
        binding.myName = myName
    }

    /**
     * Click handler for the Done button.
     */
    private fun addNickname(view: View) {
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

//        nicknameTextView.text = editText.text
//        editText.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE



//        myName?.nickname = binding.nicknameEdit.text.toString()
//        binding.nicknameEdit.visibility = View.GONE
//        view.visibility = View.GONE
//
//        binding.nicknameText.visibility = View.VISIBLE


        /*binding can also be written like this:*/

        binding.apply {
            /**When using data binding, it is necessary to explicitly convert the Editable to a String.*/
            myName?.nickname = nicknameEdit.text.toString()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE

            invalidateAll()
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
