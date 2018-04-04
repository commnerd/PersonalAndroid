package net.michaeljmiller.bundles.api.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import net.michaeljmiller.R

class ApiListAdapter<T>(val cont: Context) {
    fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var listItem = convertView
        if (listItem == null) {
            // listItem = LayoutInflater.from(context).inflate(this.resource, parent, false)
        }

        // val currentRestaurant = this.objects.get(position)

        val label = listItem!!.findViewById(R.id.line_manage_label) as TextView
        // label.text = currentRestaurant.name

        listItem.findViewById<Button>(R.id.line_manage_button_delete).setOnClickListener {
            view -> (view.parent.parent as ListView).performItemClick(view, position, 0)
        }

        listItem.findViewById<Button>(R.id.line_manage_button_edit).setOnClickListener(View.OnClickListener {
            // this.objects.drop(position)
            (it.parent.parent as ListView).performItemClick(it, position, 0)
        })

        return listItem
    }
}