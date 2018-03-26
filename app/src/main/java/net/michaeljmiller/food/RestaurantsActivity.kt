package net.michaeljmiller.food

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import net.michaeljmiller.R
import android.os.Bundle
import android.view.View
import android.widget.*

import kotlinx.android.synthetic.main.activity_food_restaurants.*
import net.michaeljmiller.adapters.food.RestaurantArrayAdapter
import net.michaeljmiller.models.food.Restaurant

class RestaurantsActivity : AppCompatActivity() {

    var restaurants = arrayOf(
            Restaurant(1, "test"),
            Restaurant(2, "Blah")
    )

    var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_restaurants)
        setSupportActionBar(toolbar)

        listView = findViewById<ListView>(R.id.restaurant_list)

        var adapter = RestaurantArrayAdapter(this, R.layout.line_manage_wiget, R.id.line_manage_label, restaurants)

        listView!!.adapter = adapter

        listView!!.setOnItemClickListener {
            _, view, position, _ -> handleClick(view, position)
        }
    }

    fun handleClick(v: View, position: Int) {
        if(v.id == R.id.line_manage_button_delete) deleteRestaurant(position)
        if(v.id == R.id.line_manage_button_edit) startActivity(Intent(this, RestaurantActivity::class.java))
    }

    fun deleteRestaurant(position: Int) {
        android.util.Log.i("deleted", position.toString() + ": THE SIZE: " + restaurants.size.toString())
        listView!!.invalidateViews()
    }
}