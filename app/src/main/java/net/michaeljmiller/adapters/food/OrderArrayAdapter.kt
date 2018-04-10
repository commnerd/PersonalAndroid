package net.michaeljmiller.adapters.food

import android.content.Context
import android.view.View
import android.view.ViewGroup
import net.michaeljmiller.bundles.api.models.food.Restaurant
import android.widget.ArrayAdapter


/**
 * Created by commnerd on 3/13/18.
 */

class OrderArrayAdapter : ArrayAdapter<Restaurant> {

    protected val textViewResourceId: Int
    protected val objects: Array<out Restaurant>

    constructor(context: Context, resource: Int, textViewResourceId: Int, objects: Array<out Restaurant>) : super(context, resource, textViewResourceId, objects) {
        this.textViewResourceId = textViewResourceId
        this.objects = objects
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup?): View {
        var listItem = convertView
        /*
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(this.textViewResourceId, parent, false)


        val currentRestaurant = this.objects.get(position)
        */
        return listItem
    }
}