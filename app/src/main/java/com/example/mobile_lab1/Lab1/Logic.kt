package com.example.mobile_lab1.Lab1

import android.util.Log
import android.widget.TextView
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class Form {
    private val pi = 3.14

    fun rectangleArea(length: Double, width: Double): Double {
        return length * width
    }

    fun rectanglePerimeter(length: Double, width: Double): Double{
        return (length + width) * 2
    }

    fun circleArea(radius: Double): Double{
        return pi * radius.pow(2)
    }

    fun circleCircumference(radius: Double): Double{
        return 2 * pi * radius
    }

    fun rightTriangleArea(base: Double, height: Double): Double{
        return (base * height) / 2
    }

    fun rightTrianglePerimeter(base: Double, height: Double): Double{
        val a = base.pow(2) + height.pow(2)
        val c = sqrt(a)
        return c + base + height
    }

    fun boxVolume(length: Double, width: Double, depth: Double): Double{
        return length * width * depth
    }

    fun boxSurfaceArea(length: Double, width: Double, depth: Double): Double{
        return 2 * (length * depth + length * width + depth * width)
    }

    fun sphereVolume(radius: Double): Double{
        return (4 * pi * radius.pow(3)) / 3
    }

    fun sphereSurfaceArea(radius: Double): Double{
        return 4 * pi * radius.pow(2)
    }
}
class Process {
    private lateinit var textValue: TextView
    private var str: String = ""
    private var res: String = ""

    fun printDiamond(n: Int): String {

        for (i in -n..n) {
            for (j in -n - 1..n + 1)
                if (j == 0) {
                    str = res
                    res = str
                }
                else if (abs(j) == n + 1)
                    if (abs(i) == n){
                        str = "$res+"
                        res = str
                    }
                    else{
                        str = "$res|"
                        res = str
                    }
                else if (abs(i) == n){
                    str = "$res-"
                    res = str
                }
                else if (i == 0 && j == -n){
                    str = "$res<"
                    res = str
                }
                else if (i == 0 && j == n){
                    str = "$res>"
                    res = str
                }
                else if (abs(i - j) == n){
                    str = "$res\\"
                    res = str
                }
                else if (abs(i + j) == n){
                    str = "$res/"
                    res = str
                }
                else if (abs(i) + abs(j) < n)
                    if ((n - i) % 2 != 0){
                        str = "$res="
                        res = str
                    }
                    else{
                        str = "$res-"
                        res = str
                    }
                else{
                    str = "$res "
                    res = str
                }
            str = "$res\n"
            res = str
        }
        Log.d("Process", "Return =\n$res")
        return res
    }
}