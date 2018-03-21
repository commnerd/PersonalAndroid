package net.michaeljmiller.services

import android.annotation.TargetApi
import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.Handler

/**
 * Created by commnerd on 3/21/18.
 */
@TargetApi(21)
class DailyReminderService: JobService() {

    private val DAY_LENGTH: Int = 86400

    /**
     * When the app's MainActivity is created, it starts this service. This is so that the
     * activity and this service can communicate back and forth. See "setUiCallback()"
     */
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        return Service.START_NOT_STICKY
    }

    override fun onStartJob(params: JobParameters): Boolean {
        // The work that this service "does" is simply wait for a certain duration and finish
        // the job (on another thread).

        // Return true as there's more work to be done with this job.
        return true
    }

    override fun onStopJob(params: JobParameters): Boolean {
        // Stop tracking these job parameters, as we've 'finished' executing.

        // Return false to drop the job.
        return false
    }

}