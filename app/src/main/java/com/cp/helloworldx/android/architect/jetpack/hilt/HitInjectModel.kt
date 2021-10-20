package com.cp.helloworldx.android.architect.jetpack.hilt

import javax.inject.Inject

public class HitInjectModel @Inject constructor(var service: AnalyticsService) {
    var time = service.analyticsMethods()

}