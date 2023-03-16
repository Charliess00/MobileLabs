package com.example.mobile_lab1.Lab1

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_lab1.R
import kotlin.Double



class MainActivityLab1 : AppCompatActivity() {

    private lateinit var dropdown: Spinner
    private lateinit var selected: String
    private lateinit var logic: Any
    private lateinit var res: TextView
    private lateinit var calculate: Button
    private lateinit var clear: TextView

    private lateinit var lenght: EditText
    private lateinit var width: EditText
    private lateinit var radius: EditText
    private lateinit var base: EditText
    private lateinit var height: EditText
    private lateinit var depth: EditText

    private lateinit var lenght_text: String
    private lateinit var width_text: String
    private lateinit var radius_text: String
    private lateinit var base_text: String
    private lateinit var height_text: String
    private lateinit var depth_text: String

    private var lenght_value: Double = 0.0
    private var width_value: Double = 0.0
    private var radius_value: Double = 0.0
    private var base_value: Double = 0.0
    private var height_value: Double = 0.0
    private var depth_value: Double = 0.0

    private lateinit var items: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inite()

        clear.setOnClickListener{
            lenght.text.clear()
            width.text.clear()
            radius.text.clear()
            base.text.clear()
            height.text.clear()
            depth.text.clear()
        }

        calculate.setOnClickListener{
            calculate_init()


            if (selected == "Rectangle Area")
                logic = Form().rectangleArea(lenght_value, width_value)

            if (selected == "Rectangle Perimeter")
                logic = Form().rectanglePerimeter(lenght_value, width_value)

            if (selected == "Circle Area")
                logic = Form().circleArea(radius_value)

            if (selected == "Circle Circumference")
                logic = Form().circleCircumference(radius_value)

            if (selected == "Right Triangle Area")
                logic = Form().rightTriangleArea(base_value, height_value)

            if (selected == "Right Triangle Perimeter")
                logic = Form().rightTrianglePerimeter(base_value, height_value)

            if (selected == "Box Volume")
                logic = Form().boxVolume(lenght_value, width_value, depth_value)

            if (selected == "Box Surface Area")
                logic = Form().boxSurfaceArea(lenght_value, width_value, depth_value)

            if (selected == "Sphere Volume")
                logic = Form().sphereVolume(radius_value)

            if (selected == "Sphere Surface Area")
                logic = Form().sphereSurfaceArea(radius_value)



            res.text = logic.toString()
        }

    }

    private fun calculate_init() {
        selected = dropdown.selectedItem.toString()

        if (lenght.text.toString() != ""){
            lenght_text = lenght.text.toString()
            lenght_value = lenght_text.toDouble()
        } else
            lenght_value = 0.0

        if (depth.text.toString() != ""){
            depth_text = depth.text.toString()
            depth_value = depth_text.toDouble()
            Log.d("Test1", "init - $depth_value")
        } else
            depth_value = 0.0

        if (width.text.toString() != ""){
            width_text = width.text.toString()
            width_value = width_text.toDouble()
        } else
            width_value = 0.0

        if (radius.text.toString() != ""){

            radius_text = radius.text.toString()
            radius_value = radius_text.toDouble()
        } else
            radius_value = 0.0

        if (base.text.toString() != ""){

            base_text = base.text.toString()
            base_value = base_text.toDouble()
        } else
            base_value = 0.0

        if (height.text.toString() != ""){

            height_text = height.text.toString()
            height_value = height_text.toDouble()
        } else
            height_value = 0.0
    }

    private fun inite() {
        dropdown = findViewById(R.id.spinner)
        items = resources.getStringArray(R.array.Shapes)
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dropdown.adapter = adapter

        res = findViewById(R.id.res)
        calculate = findViewById(R.id.calculate)
        clear = findViewById(R.id.clear_btn)

        lenght = findViewById(R.id.length_tv)
        width = findViewById(R.id.width_tv)
        radius = findViewById(R.id.radius_tv)
        base = findViewById(R.id.base_tv)
        height = findViewById(R.id.height_tv)
        depth = findViewById(R.id.depth_tv)
    }


}