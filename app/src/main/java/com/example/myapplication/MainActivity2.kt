package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val name = intent.getStringExtra("NAME")
        val age = intent.getIntExtra("Age",0)
        val isUnderage = intent.getBooleanExtra("UnderAge",true)

        mailbtn.setOnClickListener({
            val email = editTextTextPersonName.text.toString()
            val i = Intent()
            i.action = Intent.ACTION_SENDTO
            i.data = Uri.parse("mailto:$email")
            startActivity(i)
        })

        browsebtn.setOnClickListener({
            val addr = editTextTextPersonName.text.toString()
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("http://$addr")
            startActivity(i)
        })

        dialbtn.setOnClickListener({
            val num = editTextTextPersonName.text.toString()
            val i = Intent()
            i.action = Intent.ACTION_DIAL
            i.data = Uri.parse("tel:$num")
            startActivity(i)
        })

    }
}