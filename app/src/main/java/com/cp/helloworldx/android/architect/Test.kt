package com.cp.helloworldx.android.architect

import android.app.Activity
import android.os.Bundle
import java.util.ArrayList

class Test : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val aa = ArrayList<String>()

        intent.putStringArrayListExtra("key", aa)
    }
}