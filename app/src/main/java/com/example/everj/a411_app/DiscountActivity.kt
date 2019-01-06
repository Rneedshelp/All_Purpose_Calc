package com.example.everj.a411_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_discount.*
import kotlinx.android.synthetic.main.activity_discount.view.*

class DiscountActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discount)
        setSupportActionBar(findViewById(R.id.app_toolbar)) //Set up Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //Back button to homepage

        fun set_result(args: Double, argstoo : Double) {
            purchase_output.text =  "$" + String.format("%.2f", args) //Ouputs your discounted price
            savings_output.text = "$" + String.format("%.2f", argstoo) //Total savings outputed aswell

        }

        fun calculatediscount() {

            if(purchase_subtotal_input.text.isEmpty() || discount_input.text.isEmpty()){  //Set output to 0 if inputs are empty
                set_result(0.00,0.00)
            }
            else {
                val savings = (purchase_subtotal_input.text.toString().toDouble() * discount_input.text.toString().toDouble()) / 100
                val value = purchase_subtotal_input.text.toString().toDouble() - savings

                set_result(value, savings)
            }
        }


        //Edit TextFunction with an object of TectWatcher to pass EditText widgets
        fun EditText.textwatch() {
            this.addTextChangedListener(object: TextWatcher
            {

                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    calculatediscount()
                }


            })


        }

        purchase_subtotal_input.textwatch()
        discount_input.textwatch()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean //Add ToolBar to this activity
    {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean
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
        }
        return super.onOptionsItemSelected(item)
    }


}