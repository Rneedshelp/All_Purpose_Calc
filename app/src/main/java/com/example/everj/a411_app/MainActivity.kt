//Conversion Calculator By Richard Echeverria
//Able to use 5 different calculators and more to be added as practice


package com.example.everj.a411_app
import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.everj.a411_app.R.array.list_array
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.app_toolbar)) //Setup the toolbar/Action bar for the app
       listview.adapter = ArrayAdapter.createFromResource(this,R.array.list_array,android.R.layout.simple_list_item_1) //Create Viewlist adapter
        listview.setOnItemClickListener {_,_, position,_-> //when case to start activity when list view item selected
            when(position)
            {
                0->{
                    intent = Intent(this,BMIActivity::class.java)
                    startActivity(intent)
                }
                1->{
                    intent = Intent(this,UnitActivity::class.java)
                    startActivity(intent)
                }
                2->{
                    intent = Intent(this,CurrencyActivity::class.java)
                    startActivity(intent)
                }
                3->{
                    intent = Intent(this,DiscountActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean //Create Action bar/Toolbar and infalte with values
    {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean
    {
         when(item?.itemId) //Add when cases for activity startup when selected
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
