package com.example.mobile_lab1.Lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mobile_lab1.Lab1.Cottage
import com.example.mobile_lab1.Lab1.House
import com.example.mobile_lab1.Lab1.Office
import com.example.mobile_lab1.R

class MainActivityLab5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        main()
    }

    private fun main(){
        val buildings = arrayOf(
            House(30, 40, 50, 60, "George Washington", true),
            House(20, 30, 20, 30, "John Adams"),
            Cottage(10, 20, 30, "Thomas Jefferson", true),
            House(25, 35, 45, 55, "James Madison", true),
            Cottage(35, 25, 35, "James Monroe", false),
            House(38, 48, 38, 48, "John Quincy Adams", true),
            House(70, 80, 70, 80),
            House(65, 75, 65, 75, null, true),
            Office(100, 200, 300, 400),
            Office(150, 250, 350, 450, "Bridgestone/Firestone", 100),
            Office(200, 300, 400, 500, "Caterpillar", 100),
            Office(75, 175, 275, 375, "Cracker Barrel"),
            Office(120, 220, 320, 420, null, 50),
            Office(80, 180, 280, 380, "Nissan")
        )

         Log.d("Testy1y", "Houses")
        Log.d("Testy1y", "----------")

        for (building in buildings) {
            if (building is House) {
                Log.d("Testy1y", building.toString())
            }
        }

        Log.d("Testy1y", "")

        Log.d("Testy1y", "Offices")
        Log.d("Testy1y", "----------")
        for (building in buildings) {
            if (building is Office) {
                Log.d("Testy1y", building.toString())
            }
        }
    }

}