package net.michaeljmiller.android.personal.lib.interfaces

import java.util.*

interface Reminder {
        fun getId(): Int?
        fun getClass(): String
        fun getReference(): String
        fun getReminder(): String
        fun getCreatedAt(): Date?
        fun getUpdatedAt(): Date?
}