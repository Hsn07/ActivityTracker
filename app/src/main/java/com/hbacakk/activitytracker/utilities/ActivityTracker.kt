package com.hbacakk.activitytracker.utilities

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

class ActivityTracker : Application.ActivityLifecycleCallbacks {
    companion object {
        private var instance = ActivityTracker()
        private var isInitialized: Boolean = false
        fun init(application: Application) {
            if (isInitialized)
                return
            application.registerActivityLifecycleCallbacks(instance)
            isInitialized = true
        }

        private const val TAG = "LifecycleCallbacks"
    }

    private var activityCount = 0




    override fun onActivityCreated(activity: Activity, p1: Bundle?) {
        Log.d(TAG, "onActivityCreated: ${activity.localClassName} ")
    }

    override fun onActivityStarted(activity: Activity) {

        Log.d(TAG, "onActivityStarted: ${activity.localClassName} ")
        activityCount++
        if (activityCount == 1)
            Log.d(TAG, "application moved foreground")
    }

    override fun onActivityResumed(activity: Activity) {
        Log.d(TAG, "onActivityResumed: ${activity.localClassName} ")
    }

    override fun onActivityPaused(activity: Activity) {
        Log.d(TAG, "onActivityPaused: ${activity.localClassName} ")
    }

    override fun onActivityStopped(activity: Activity) {
        Log.d(TAG, "onActivityStopped: ${activity.localClassName} ")
        activityCount--
        if (activityCount < 0)
            activityCount = 0
        if (activityCount == 0) {
            //Log.d(TAG, "onActivityStopped: activityCount :$activityCount")
            Log.d(TAG, "application moved background")
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity, p1: Bundle) {
        Log.d(TAG, "onActivitySaveInstanceState: ${activity.localClassName} ")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.d(TAG, "onActivityDestroyed: ${activity.localClassName} ")
    }
}