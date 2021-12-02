package com.example.myconvertorapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val convertButton = findViewById<ImageButton>(R.id.convert_fragment_button)
        val addQuantity = findViewById<ImageButton>(R.id.add_quantity_fragment_button)

        convertButton.setOnClickListener(){

            replaceFragment(ConvertFragment())
        }

        addQuantity.setOnClickListener(){

            replaceFragment(AddQuantityFragment())
        }


    }
    private fun replaceFragment(fragment: Fragment){

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
    }
}