package net.michaeljmiller.bundles.api.models.food

import net.michaeljmiller.bundles.api.models.LaravelModel
import java.util.Date

/**
 * Created by commnerd on 3/13/18.
 */
data class Order(
        id: Int,
        var label: String,
        var notes: String,
        created_at: Date,
        updated_at: Date
): LaravelModel(id, created_at, updated_at)