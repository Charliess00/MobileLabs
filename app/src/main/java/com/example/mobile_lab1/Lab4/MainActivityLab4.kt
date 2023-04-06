package com.example.mobile_lab1.Lab4

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_lab1.Lab1.Gate
import com.example.mobile_lab1.R


class MainActivityLab4 : AppCompatActivity() {
    private var click = 1
    private val gate = Gate()
    private lateinit var open_res: TextView
    private lateinit var thru_res: TextView
    private lateinit var res: TextView
    private lateinit var h: TextView
    private lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        inite()
        test1()
        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                click += 1
                if (click == 1) {
                    //first time clicked to do this
                    test1()
                    return
                }
                if (click == 2) {
                    //first time clicked to do this
                    test2()
                    return
                }
                if (click == 3) {
                    //first time clicked to do this
                    test3()
                    return
                }
                if (click == 4) {
                    //first time clicked to do this
                    test4()
                    return
                }
                if (click == 5) {
                    //first time clicked to do this
                    test5()
                    return
                }
                if (click == 6) {
                    //first time clicked to do this
                    test6()
                    return
                }
                else {
                    //check how many times clicked and so on
                    click = 0
                    test1()
                }
            }
        })
    }

    private fun test6() {
        val n = 3

        h.text = getString(R.string.gate_test5)
        gate.open(-1)
        open_res.text = gate.getSwingDirection().toString()
        res.text = gate.thru(n).toString()
        thru_res.text = n.toString()
    }

    private fun test5() {
        val n = 3

        h.text = getString(R.string.gate_test5)
        gate.open(1)
        open_res.text = gate.getSwingDirection().toString()
        res.text = gate.thru(n).toString()
        thru_res.text = n.toString()

    }

    private fun test4() {
        h.text = getString(R.string.gate_test4)
        gate.open(2)
        open_res.text = gate.getSwingDirection().toString()
        res.text = gate.toString()
    }

    private fun test3() {
        h.text = getString(R.string.gate_test3)
        gate.open(-1)
        open_res.text = gate.getSwingDirection().toString()
        res.text = gate.toString()
    }

    @SuppressLint("SetTextI18n")
    private fun test2() {
        h.text = getString(R.string.gate_test2)
        gate.open(1)
        open_res.text = gate.getSwingDirection().toString()
        res.text = gate.toString()
    }

    private fun test1() {
        val gate1 = Gate()
        h.text = getString(R.string.gate_test1)
        open_res.text = gate1.getSwingDirection().toString()
        res.text = gate1.toString()
    }

    private fun inite() {
        open_res = findViewById(R.id.open_res)
        thru_res = findViewById(R.id.thru_res)
        h = findViewById(R.id.H1)
        res = findViewById(R.id.res)
        btn = findViewById(R.id.button)
    }
}