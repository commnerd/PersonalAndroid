package net.michaeljmiller.android.personal.lib.models

import java.util.*

open class LaravelModel(
    private var id : Int?,
    private var created_at : Date?,
    private var updated_at : Date?
) {

    companion object {
        val dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'"
    }

    fun getId() : Int? {
        return id
    }

    fun setId(id : Int) {
        this.id = id
    }

    fun getCreatedAt() : Date?
    {
        return created_at
    }

    fun setCreatedAt(date : Date?) {
        created_at = date
    }

    fun getUpdatedAt() : Date?
    {
        return updated_at
    }

    fun setUpdatedAt(date : Date?) {
        created_at = date
    }
}