package com.cp.helloworldx.android.architect.jetpack.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

object AnalyticsModule{

    fun provideAnalyticsService():AnalyticsService{
        return AnalyticsServiceImpl()
    }
}
