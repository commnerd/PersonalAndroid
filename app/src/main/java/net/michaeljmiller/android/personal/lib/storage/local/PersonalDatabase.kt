package net.michaeljmiller.android.personal.lib.storage.local

import net.michaeljmiller.android.personal.lib.storage.local.dao.DailyReminderDao
import net.michaeljmiller.android.personal.lib.storage.local.utils.Converters
import net.michaeljmiller.android.personal.lib.storage.local.dao.QuoteDao
import net.michaeljmiller.android.personal.lib.models.DailyReminder
import net.michaeljmiller.android.personal.lib.models.Quote
import androidx.room.TypeConverters
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Database
import androidx.room.Room

@Database(entities = [
    DailyReminder::class,
    Quote::class
], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PersonalDatabase : RoomDatabase() {

    abstract fun dailyReminderDao() : DailyReminderDao
    abstract fun quoteDao() : QuoteDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PersonalDatabase? = null

        fun getDatabase(context: Context): PersonalDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonalDatabase::class.java,
                    "personal_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}