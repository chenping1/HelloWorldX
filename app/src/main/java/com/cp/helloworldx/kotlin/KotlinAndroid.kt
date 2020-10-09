package com.cp.helloworldx.kotlin

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //- Android KTX

    private val openPostActivityCustom =
            registerForActivityResult(PostActivityContract(2)) { result ->
            }


}

class PostActivityContract(val postId: Int) : ActivityResultContract<Int, String?>() {
    override fun createIntent(context: Context, input: Int?): Intent {
        TODO("Not yet implemented")
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        TODO("Not yet implemented")
    }

}



