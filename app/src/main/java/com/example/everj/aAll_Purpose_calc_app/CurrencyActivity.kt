package com.example.everj.aAll_Purpose_calc_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_currency.*

class CurrencyActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)
        setSupportActionBar(findViewById(R.id.app_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //Set up action/toolbar
        val moneyspinner: Spinner = findViewById(R.id.money_spinner1) //create adapter for first spinner layout
        moneyspinner.adapter = ArrayAdapter.createFromResource(this, R.array.currency_array, android.R.layout.simple_spinner_item)
        val cashspinner: Spinner = findViewById(R.id.money_spinner2)//create adapter for second spinner layout
        cashspinner.adapter = ArrayAdapter.createFromResource(this, R.array.currency_array, android.R.layout.simple_spinner_item)

        fun TextView.set_result(args: Double, name : String) { //function to output result from calculations
            this.text = String.format("%.2f ", args) + name
        }

        fun computeexchange(){ //Calls to grab both spinner values and compares string texts respectively From to To
            if(currency_input.text.isEmpty()) //If no input value just return back no calculation
            {return }
            val from = money_spinner1.getItemAtPosition(money_spinner1.selectedItemPosition).toString() //Grab first spinner text
            val to = money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString()  //Grab second spinner text
            when (from.toString())  //When From to To string sequence matches one of these combinations, call respective algorithm
            {
                "USD" -> {
                    when (to.toString()) {
                        "JPY" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 113.25,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "GBP" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 0.77,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "CAD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 1.31,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "AUD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 1.39,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "EUR" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 0.88,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "USD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble(),
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                    }
                }
                "GBP" -> {
                    when (to.toString()) {
                        "JPY" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 147,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "GBP" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble(),
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "CAD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 1.70,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "AUD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 1.81,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "EUR" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 1.14,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "USD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 1.30,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                    }
                }
                "JPY" -> {
                    when (to.toString()) {
                        "JPY" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble(),
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "GBP" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 0.0068,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "CAD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * .012,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "AUD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 0.012,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "EUR" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 0.0078,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "USD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() *0.0088,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                    }
                }
                "CAD" -> {
                    when (to.toString()) {
                        "JPY" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 86.36,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "GBP" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 0.59,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "CAD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble(),
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "AUD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 1.06,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "EUR" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 0.67,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "USD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 0.76,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                    }
                }
                "AUD" -> {
                    when (to.toString()) {
                        "JPY" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 81.42,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "GBP" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 0.55,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "CAD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 0.94,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "AUD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble(),
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "EUR" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 0.63,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "USD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 0.72,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                    }
                }
                "EUR" -> {
                    when (to.toString()) {
                        "JPY" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 128.91,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "GBP" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 0.88,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "CAD" -> {currency_result.set_result(currency_input.text.toString().toDouble() * 1.49,
                            money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "AUD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() *1.58,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "EUR" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble(),
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                        "USD" -> {
                            currency_result.set_result(currency_input.text.toString().toDouble() * 1.14,
                                money_spinner2.getItemAtPosition(money_spinner2.selectedItemPosition).toString())
                        }
                    }
                }
            }


        }

        fun Spinner.listener() {  //Add spinner listener to whenever spinner item selected changes
            this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                    computeexchange()
                }
                override fun onNothingSelected(parent: AdapterView<*>) {}
            }
        }
        fun EditText.moneywatch() { //Input text watcher to auto calculate whenever input changes
            this.addTextChangedListener(object: TextWatcher
            {

                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    computeexchange()
                }


            })


        }
        currency_input.moneywatch()
        money_spinner1.listener()
        money_spinner2.listener()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean  //Add toolbar to this activity
    {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean//Inflate with activites you can reach to
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
