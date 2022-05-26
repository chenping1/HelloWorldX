package com.cp.helloworldx.android.delegation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

class AnalyticsDelegateImpl : AnalyticsDelegate,DefaultLifecycleObserver{
    override fun registerAnalytics(lifecycle: Lifecycle) {
        TODO("Not yet implemented")
        lifecycle.addObserver(this)
    }

    override fun onCreate(owner: LifecycleOwner) {

    }

    override fun onStart(owner: LifecycleOwner) {
    }

    override fun onResume(owner: LifecycleOwner) {
    }

    override fun onPause(owner: LifecycleOwner) {
    }

    override fun onStop(owner: LifecycleOwner) {
    }

    override fun onDestroy(owner: LifecycleOwner) {
    }
}