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
class Gate {
    var mSwing = CLOSED

    companion object {
        const val IN = 1
        const val OUT = -1
        const val CLOSED = 0
        const val INVALID = 2
    }

    fun setSwing(direction: Int): Boolean {
        if (direction == IN || direction == OUT) {
            mSwing = direction
            return true
        }
        mSwing = INVALID
        return false
    }

    fun open(direction: Int): Boolean {
        if (direction != IN && direction != OUT) {
            mSwing = INVALID
            return false
        }
        if (setSwing(direction)) {
            if (direction == IN) {
                return true
            } else if (direction == OUT) {
                return true
            }
        }
        return false
    }

    fun close() {
        mSwing = CLOSED
    }

    fun getSwingDirection(): Int {
        return mSwing
    }

    fun thru(count: Int): Int {
        if (mSwing == IN) {
            return count
        } else if (mSwing == OUT) {
            return -count
        }
        return 0
    }

    override fun toString(): String {
        return when (mSwing) {
            IN -> "Gate is open and swings to enter the pen only"
            OUT -> "Gate is open and swings to exit the pen only"
            CLOSED -> "Gate is close"
            else -> "Gate has an invalid swing direction"
        }
    }
}
