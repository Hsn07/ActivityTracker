package com.hbacakk.activitytracker

import android.app.Application
import com.hbacakk.activitytracker.utilities.ActivityTracker

class ApplicationClass: Application() {
    override fun onCreate() {
        super.onCreate()
        ActivityTracker.init(this)
        //registerActivityLifecycleCallbacks(ActivityTracker(this))
    }
}