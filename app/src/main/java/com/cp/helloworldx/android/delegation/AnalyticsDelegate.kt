package com.cp.helloworldx.android.delegation

import androidx.lifecycle.Lifecycle

interface AnalyticsDelegate {
    fun registerAnalytics(lifecycle: Lifecycle)
}