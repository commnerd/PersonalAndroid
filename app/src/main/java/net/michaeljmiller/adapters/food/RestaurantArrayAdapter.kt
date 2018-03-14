package net.michaeljmiller.adapters.food

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import net.michaeljmiller.R
import net.michaeljmiller.models.food.Restaurant

/**
 * Created by commnerd on 3/13/18.
 */
class RestaurantArrayAdapter : ArrayAdapter<Restaurant> {

    protected val resource: Int
    protected val textViewResourceId: Int
    protected val objects: Array<out Restaurant>

    constructor(context: Context, resource: Int, textViewResourceId: Int, objects: Array<out Restaurant>) : super(context, resource, textViewResourceId, objects) {
        this.textViewResourceId = textViewResourceId
        this.resource = resource
        this.objects = objects
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var listItem = convertView
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(this.resource, parent, false)
        }

        val currentRestaurant = this.objects.get(position)

        val release = listItem!!.findViewById(R.id.line_manage_label) as TextView
        release.setText(currentRestaurant.name)

        return listItem
    }
}