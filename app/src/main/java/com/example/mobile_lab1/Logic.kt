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

open class Building
    (private var mLength: Int, private var mWidth: Int, private var mLotLength: Int,
     private var mLotWidth: Int)
{

    fun getLength(): Int {
        return mLength
    }

    fun getWidth(): Int {
        return mWidth
    }

    fun getLotLength(): Int {
        return mLotLength
    }

    fun getLotWidth(): Int {
        return mLotWidth
    }

    fun setLength(length: Int) {
        mLength = length
    }

    fun setWidth(width: Int) {
        mWidth = width
    }

    fun setLotLength(lotLength: Int) {
        mLotLength = lotLength
    }

    fun setLotWidth(lotWidth: Int) {
        mLotWidth = lotWidth
    }

    fun calcBuildingArea(): Int {
        return mLength * mWidth
    }

    fun calcLotArea(): Int {
        return mLotLength * mLotWidth
    }

    override fun toString(): String {
        return ""
    }
}

open class House
    (length: Int, width: Int, lotLength: Int, lotWidth: Int,
     owner: String? = null, hasPool: Boolean = false) : Building(length, width, lotLength, lotWidth)
{

    private var mOwner: String? = owner
    private var mPool: Boolean = hasPool

    fun getOwner(): String? {
        return mOwner
    }

    fun hasPool(): Boolean {
        return mPool
    }

    fun setOwner(owner: String?) {
        mOwner = owner
    }

    fun setPool(hasPool: Boolean) {
        mPool = hasPool
    }

    override fun toString(): String {
        var result = super.toString()

        result += "Owner: " + (getOwner() ?: "n/a")

        if (hasPool()) {
            result += "; has a pool"
        }
        if (calcLotArea() > calcBuildingArea()) {
            result += "; has big open space"
        }
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is House) {
            return false
        }
        return super.equals(other) && mPool == other.mPool
    }

}

class Cottage : House
{
    private val mSecondFloor: Boolean

    constructor(dimension: Int, lotLength: Int, lotWidth: Int) : super(dimension, dimension, lotLength, lotWidth) {
        mSecondFloor = false
    }

    constructor(dimension: Int, lotLength: Int, lotWidth: Int, owner: String, secondFloor: Boolean) : super(dimension, dimension, lotLength, lotWidth, owner) {
        mSecondFloor = secondFloor
    }

    fun hasSecondFloor(): Boolean {
        return mSecondFloor
    }

    override fun toString(): String {
        var result = super.toString()

        if (mSecondFloor) {
            result += "; is a two story cottage"
        } else result += "; is a cottage"



        return result
    }
}

class Office : Building
{
    private var mBusinessName: String? = null
    private var mParkingSpaces = 0

    companion object {
        fun getTotalOffices(): Int {
            return sTotalOffices
        }
        private var sTotalOffices = 0
    }

    constructor(length: Int, width: Int, lotLength: Int, lotWidth: Int)
            : super(length, width, lotLength, lotWidth) {
        sTotalOffices++
    }

    constructor(length: Int, width: Int, lotLength: Int, lotWidth: Int, businessName: String)
            : super(length, width, lotLength, lotWidth) {
        mBusinessName = businessName
        sTotalOffices++
    }

    constructor(length: Int, width: Int, lotLength: Int, lotWidth: Int, businessName: String?, parkingSpaces: Int)
            : super(length, width, lotLength, lotWidth) {
        mBusinessName = businessName
        mParkingSpaces = parkingSpaces
        sTotalOffices++
    }

    fun getBusinessName(): String? {
        return mBusinessName
    }

    fun getParkingSpaces(): Int {
        return mParkingSpaces
    }

    fun setBusinessName(businessName: String) {
        mBusinessName = businessName
    }

    fun setParkingSpaces(parkingSpaces: Int) {
        mParkingSpaces = parkingSpaces
    }

    override fun toString(): String {
        var result = super.toString()
        var v = if(mParkingSpaces == 0) "" else "; has $mParkingSpaces parking spaces"
        result += "\nBusiness: " + (mBusinessName ?: "unoccupied") + "$v"
        result += " (total offices: ${getTotalOffices()})"
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Office) {
            return false
        }
        return super.equals(other) && mParkingSpaces == other.mParkingSpaces
    }
}
