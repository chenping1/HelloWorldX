package com.cp.helloworldx.kotlin

import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * 协程 是比线程更加轻量级的存在，一个线程可以有多个协程
 * 如果遇到堵塞， 会立刻yield 掉， 并记录当前栈上的数据，堵塞完后立刻 找一个线程恢复
 * 好处: 1. 协程不是被操作系统内核所管理，而完全是由程序所控制，   性能提升，  不像线程间切换 耗费太大资源
 *      2. 不需要线程锁机制 因为只有一个线程 不存在写变量冲突
 */
class KotlinCoroutine {

    suspend fun create(){
        //不阻碍线程
        GlobalScope.launch {
            coroutineScope{//协程作用域

            }
        }
        //祖塞
        runBlocking {

        }

        //启动一个不堵塞的 协程
        var deffer = GlobalScope.async {
           testA()
        }
        deffer.await();//结果

    }


    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }
            })
        }
    }

    fun test(){

        GlobalScope.launch {
            val a = async   {
                testA()
            }

            val b = GlobalScope.launch {
                testB()
            }

            val result = a.await() + b
        }


    }

    suspend fun testA():String {
        for (i in 1..3) {

        }
        delay(2)
        return "A"
    }

    suspend fun testB(){
        coroutineScope {
            var a = testA()
            a = "A"+ a.toString()
        }
    }


}