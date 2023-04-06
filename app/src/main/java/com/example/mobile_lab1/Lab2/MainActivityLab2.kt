package com.example.mobile_lab1.Lab2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_lab1.R

class MainActivityLab2 : AppCompatActivity() {
    private lateinit var dropdown: Spinner
    private lateinit var items: Array<String>
    private lateinit var selected: String

    private lateinit var logic: String
    private lateinit var text: TextView
    private lateinit var textValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        inite()

        dropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                logic = com.example.mobile_lab1.Lab1.Process().printDiamond(0)
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selected = dropdown.selectedItem.toString()
                logic = com.example.mobile_lab1.Lab1.Process().printDiamond(selected.toInt())
                Log.d("Process", "Logic =\n$logic")
                textValue.text = selected
                text.text = logic
            }
        }

    }

    private fun inite() {
        dropdown = findViewById(R.id.spinner)
        items = resources.getStringArray(R.array.Diamond)
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dropdown.adapter = adapter

        logic = com.example.mobile_lab1.Lab1.Process().printDiamond(0)

        text = findViewById(R.id.textView)
        textValue = findViewById(R.id.textValue)
    }

}