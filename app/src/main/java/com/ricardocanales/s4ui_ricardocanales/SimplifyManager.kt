package com.ricardocanales.s4ui_ricardocanales

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class SimplifyManager : LifecycleObserver {
    fun setOwner(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun createHappened() {
        Log.d("tag", "The OnCreate was invoked from SimplifyManager")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startHappened() {
        Log.d("tag", "The OnStart was invoked from SimplifyManager")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resumeHappened() {
        Log.d("tag", "The OnResume was invoked from SimplifyManager")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pauseHappened() {
        Log.d("tag", "The OnPause was invoked from SimplifyManager")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopHappened() {
        Log.d("tag", "The OnStop was invoked from SimplifyManager")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroyHappened() {
        Log.d("tag", "The OnDestroy was invoked from SimplifyManager")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onEventHappened() {
        Log.d("tag", "The OnAnyEvent was invoked from SimplifyManager")
    }
}