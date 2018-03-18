package net.michaeljmiller

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import net.michaeljmiller.food.RestaurantsActivity;

import kotlinx.android.synthetic.main.activity_food.*

class FoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val manageButton: Button = findViewById<Button>(R.id.food_button_manage)
        manageButton.setOnClickListener({
            view -> startActivity(Intent(this, RestaurantsActivity::class.java))
        })
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

    }

}
