package net.michaeljmiller.models.food

import java.sql.Date

/**
 * Created by commnerd on 3/13/18.
 */
data class Order(
        val id: Int,
        var label: String,
        var notes: String,
        val created_at: Date,
        val updated_at: Date
)