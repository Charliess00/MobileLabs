package com.example.mobile_lab1.Lab1

import kotlin.math.pow
import kotlin.Double
import kotlin.math.sqrt

class Logic {
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