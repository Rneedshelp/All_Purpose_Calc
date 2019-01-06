package com.example.everj.a411_app

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.DeadObjectException
import android.support.v4.app.SupportActivity
import android.support.v7.app.ActionBar
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_unit.*
import android.widget.Spinner


class UnitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit)
        setSupportActionBar(findViewById(R.id.app_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //Add Back to Home UP button
        val spinnerone: Spinner = findViewById(R.id.unit_spinner1) //Create Adpater for first spinner
        spinnerone.adapter =
                ArrayAdapter.createFromResource(this, R.array.units_array, android.R.layout.simple_spinner_item)
        val spinnertwo: Spinner = findViewById(R.id.unit_spinner2) //Create Adpater for second spinner
        spinnertwo.adapter =
                ArrayAdapter.createFromResource(this, R.array.units_array, android.R.layout.simple_spinner_item)

        fun TextView.set_result(args: Double, length: String) {
            this.text = String.format("%.2f ", args) + length  //Output function for results
        }

        fun computeunits() {
            if (unit_Input1.text.isEmpty()) {
                unit_result.set_result(0.00, "") //If input is empty output zero.
                return
            }
            val from = unit_spinner1.getItemAtPosition(unit_spinner1.selectedItemPosition).toString() //Value storing first spinner string
            val to = unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString() //Second spinner string item
            when (from.toString()) {  //Series of when selected cases starting specific algorithms
                "Inch" -> {        //calls for input values When From string and To strings match the first and second spinners respectively
                    when (to.toString()) {
                        "Inch" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble(),
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Feet" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 12,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Yards" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 36,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Miles" -> {
                            val mi: Double = unit_Input1.text.toString().toDouble() / 63360
                            unit_result.text = String.format("%.7f ", mi) +
                                    unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                        }
                        "Meters" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 39.37,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Millimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 25.4,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )

                        }
                        "Centimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 2.54,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Kilometer" -> {
                            val km: Double = unit_Input1.text.toString().toDouble() / 39370.079
                            unit_result.text = String.format("%.6f", km) +
                                    unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                        }
                    }
                }
                "Feet" -> {
                    when (to.toString()) {
                        "Inch" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 12,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Feet" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble(),
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Yards" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 3,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Miles" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 5280,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Meters" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 3.281,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )

                        }
                        "Millimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 304.8,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Centimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 30.48,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Kilometer" -> {
                            val km: Double = unit_Input1.text.toString().toDouble() / 3280.84
                            unit_result.text = String.format("%.6f ", km) +
                                    unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                        }
                    }
                }
                "Yards" -> {
                    when (to.toString()) {
                        "Inch" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 36,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Feet" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 3,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Yards" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble(),
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Miles" -> { //change miles for all
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 1760,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Meters" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 1.094,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }

                        "Millimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 914.4,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Centimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 91.44,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Kilometer" -> {
                            val km: Double = unit_Input1.text.toString().toDouble() / 1093.613
                            unit_result.text = String.format("%.6f ", km) +
                                    unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()

                        }
                    }
                }
                "Miles" -> {
                    when (to.toString()) {
                        "Inch" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 63360,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Feet" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 5280,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Yards" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 1760,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Miles" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble(),
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Meters" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 1609.344,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Millimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 1609344,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Centimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 160934.4,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Kilometer" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 1.609,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                    }

                }
                "Meters" -> {
                    when (to.toString()) {
                        "Inch" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 39.37,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Feet" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 3.281,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Yards" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 1.094,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Miles" -> {
                            val mi: Double = unit_Input1.text.toString().toDouble() / 1609.344
                            unit_result.text = String.format("%.6f ", mi) +
                                    unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                        }
                        "Meters" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble(),
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Millimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 1000,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Centimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 100,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Kilometer" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 1000,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                    }

                }
                "Millimeter" -> {
                    when (to.toString()) {
                        "Inch" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 25.4,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Feet" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 304.8,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Yards" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 914.4,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Miles" -> {
                            val mi: Double = unit_Input1.text.toString().toDouble() / 1609344
                            unit_result.text = String.format("%.7f ", mi) +
                                    unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                        }
                        "Meters" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 1000,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Millimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble(),
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Centimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 10,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Kilometer" -> {
                            val km: Double = unit_Input1.text.toString().toDouble() / 1000000
                            unit_result.text = String.format("%.7f ", km) +
                                    unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                        }
                    }

                }
                "Centimeter" -> {
                    when (to.toString()) {
                        "Inch" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 2.54,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Feet" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 30.48,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Yards" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 91.44,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Miles" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 160934.4,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Meters" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 100,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Millimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 10,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Centimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble(),
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Kilometer" -> {
                            val km: Double = unit_Input1.text.toString().toDouble() / 100000
                            unit_result.text = String.format("%.6f ", km) +
                                    unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                        }
                    }
                }
                "Kilometer" -> {
                    when (to.toString()) {
                        "Inch" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 39370.079,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Feet" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 3280.84,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Yards" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 1093.613,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Miles" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 1.609,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Meters" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() / 1000,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Millimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 1000000,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Centimeter" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble() * 100000,
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                        "Kilometer" -> {
                            unit_result.set_result(
                                unit_Input1.text.toString().toDouble(),
                                unit_spinner2.getItemAtPosition(unit_spinner2.selectedItemPosition).toString()
                            )
                        }
                    }

                }


            }
        }


        fun Spinner.listener(){  //Add spinner listener to whenever spinner item selected changes
            this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {

                    computeunits() //compute new changes
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
        }
        fun EditText.unitwatch() { //Input text watcher to auto calculate whenever input changes
            this.addTextChangedListener(object: TextWatcher
            {

                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    computeunits() //compute new changes
                }


            })


        }

        unit_Input1.unitwatch()
        unit_spinner1.listener()
        unit_spinner2.listener()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean  //Add toolbar to this activity
    {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean  //Inflate with activites you can reach to
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



