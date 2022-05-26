package com.cp.helloworldx.android.delegation

import androidx.appcompat.app.AppCompatActivity

/**
 * https://juejin.cn/post/7077899016091992071
 * 委托 代替 BaseActivity
 */
class MyActivity : AppCompatActivity(), AnalyticsDelegate by AnalyticsDelegateImpl(){



}