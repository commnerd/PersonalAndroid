package net.michaeljmiller.adapters.food

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
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

        val label = listItem!!.findViewById(R.id.line_manage_label) as TextView
        label.setText(currentRestaurant.name)

        listItem.findViewById<Button>(R.id.line_manage_button_delete).setOnClickListener {
            view -> (view.parent.parent as ListView).performItemClick(view, position, 0)
        }

        listItem.findViewById<Button>(R.id.line_manage_button_edit).setOnClickListener(View.OnClickListener {
            this.objects.drop(position)
            (it.parent.parent as ListView).performItemClick(it, position, 0)
        })

        return listItem
    }
}