package com.cp.helloworldx.android.architect

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

open class LifecycleObserverX : LifecycleObserver{
    private val TAG =  javaClass.simpleName

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.d(TAG,"lifecycle  onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        Log.d(TAG,"lifecycle  onDestroy")
    }



}