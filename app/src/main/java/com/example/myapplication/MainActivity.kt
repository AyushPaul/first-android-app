package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

//import kotlinx.android.synthetic.main.activity_main.*
val TAG = "MyApp"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val d = Log.d(TAG, "onCreate: ")
        textView.apply{
            text = "OHAYOOOOOOO"
            textSize = 30f
            setTextColor(getColor(R.color.purple_700))
        }

        editTextTextPersonName.apply{
            hint = "Enter Your Name"
            addTextChangedListener {
                Log.i("ViewBinding",it.toString())

                if(it.toString().length > 6 )
                {
                    button.isEnabled = false
                }
                else
                {
                    button.isEnabled = true
                }
            }
        }
        button.setOnClickListener {
            Toast.makeText(this,"Button Pressed",Toast.LENGTH_LONG).show()
        }

        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->  Toast.makeText(this,"Item is now $isChecked",Toast.LENGTH_LONG).show() }
        
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.radioButton1 -> {
                    Toast.makeText(this,"Item is now Button 1",Toast.LENGTH_LONG).show()
                }

                R.id.radioButton2 ->{
                    Toast.makeText(this,"Item is now Button 2",Toast.LENGTH_LONG).show()
                }
            }
          }

        floatingActionButton.setOnClickListener({
            val i = Intent(this,MainActivity2::class.java)
            i.putExtra("NAME" , "Ayush")
            i.putExtra("Age" , 10)
            i.putExtra("UnderAge" , false)
            startActivity(i)
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG ,"onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG ,"onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG ,"onPause: ")
    }

    override fun onStop() {
        Log.d(TAG ,"onStop: ")
        super.onStop()
    }



//    fun showToast(view: android.view.View) {
//        Toast.makeText(this,"Button Pressed",Toast.LENGTH_LONG).show()
//    }
}