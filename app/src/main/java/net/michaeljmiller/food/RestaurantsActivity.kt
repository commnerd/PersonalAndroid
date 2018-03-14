package net.michaeljmiller.food

import android.support.v7.app.AppCompatActivity
import net.michaeljmiller.R
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_food_restaurants.*
import net.michaeljmiller.adapters.food.RestaurantArrayAdapter
import net.michaeljmiller.models.food.Restaurant

class RestaurantsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_restaurants)
        setSupportActionBar(toolbar)

        val restaurants = arrayOf(
            Restaurant(1, "test"),
            Restaurant(2, "Blah")
        )

        var listView = findViewById<ListView>(R.id.restaurant_list)

        var adapter = RestaurantArrayAdapter(this, R.layout.line_manage_wiget, R.id.line_manage_label, restaurants)

        listView.adapter = adapter
    }

}
