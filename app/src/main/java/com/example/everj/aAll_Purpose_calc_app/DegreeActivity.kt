package com.example.everj.aAll_Purpose_calc_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import kotlinx.android.synthetic.main.activity_degree.*

class DegreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_degree)
        setSupportActionBar(findViewById(R.id.app_toolbar)) //setup Actionbar in this app
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        fun set_result(argf: Double, argc : Double, input : Int) {
            fahreneit_result.text = String.format("%d", input)  + "° Celcius = " + String.format("%.1f°", argf) + " Fahrenheit"
            Celcius_result.text =   String.format("%d", input)  + "° Fahrenheit = " + String.format("%.1f°", argc) + " Celcius"
        }

        fun degreeconvert(arg : Int){

                val F = ((arg * 1.8) + 32)
                val C =  (arg - 32) * 0.555555
                set_result(F,C,arg)

        }

        fun clickwatcher() {
            val button = findViewById<Button>(R.id.button)
            button.setOnClickListener()
            {
                if(degree_input.text.isEmpty()) //If input is empty set output to 0
                {
                    degreeconvert(0)
                }
                else {
                    degreeconvert(degree_input.text.toString().toInt())
                }
            }
        }

        clickwatcher()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean //Add toolbar to this activity too
    {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean  //Tool Bar menu items
    {
        when(item?.itemId)
        {
            R.id.calc_BMI ->{
                intent = Intent(this,BMIActivity::class.java)
                startActivity(intent)
            }

            R.id.calc_currency->{

                intent = Intent(this,CurrencyActivity::class.java)
                startActivity(intent)
            }
            R.id.calc_unit->{
                intent = Intent(this,UnitActivity::class.java)
                startActivity(intent)
            }
            R.id.calc_discount->{
                intent = Intent(this,DiscountActivity::class.java)
                startActivity(intent)
            }
            R.id.calc_temp->{
                intent = Intent(this,DegreeActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}