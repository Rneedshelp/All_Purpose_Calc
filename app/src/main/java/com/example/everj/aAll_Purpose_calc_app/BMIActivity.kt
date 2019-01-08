package com.example.everj.aAll_Purpose_calc_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_bmi.*
import kotlin.math.pow

class BMIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
        setSupportActionBar(findViewById(R.id.app_toolbar)) //setup Actionbar in this app
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fun TextView.set_result(args: Double) {
            this.text = String.format("%.1f", args) //Output results using TextView passed as object
        }

        fun BodyMassconversion(): Double {
            if(BMI_Feet_Input.text.isEmpty() || BMI_Inch_Input.text.isEmpty()) //If input is empty set output to 0
            {
                return 0.0
            }
            val inches = (BMI_Feet_Input.text.toString().toDouble() * 12 )+ BMI_Inch_Input.text.toString().toDouble()
            val value : Double = (703 * BMI_Weight_Input.text.toString().toDouble()) / inches.pow(2)
            return value
        }

        //function to keep track of whenever button is pressed
        fun clickwatcher() {
            val button = findViewById<Button>(R.id.BMI_button)
            button.setOnClickListener()
            {

                val value: Double = BodyMassconversion() //call BMI algorithm when button clicked
                BMI_Result.set_result(value)

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
