package com.cp.helloworldx.kotlin

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

object KotlinCoroutineX {
    @JvmStatic
    fun main(args: Array<String>) = runBlocking {

        println(log("main1"))
        launch{
            uiCode1()
            ioCode1()
            uiCode2()
            ioCode2()
        }

        ioCode1()
        println(log("main2"))
    }




    suspend fun ioCode1(){
        withContext(Dispatchers.IO){
            delay(1000)
            log("ioCode1")
        }

    }

    fun uiCode1(){
        log("uiCode1")
    }

    suspend fun ioCode2(){
        withContext(Dispatchers.IO){
            delay(1000)
            log("ioCode2")
        }
    }

    fun uiCode2(){
        log("uiCode2")
    }


    fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")
    fun log(msg: Int) = println("[${Thread.currentThread().name}] $msg")

    //sampleStart
    fun simple(): Flow<Int> = flow {
        log("Started simple flow")
        for (i in 1..3) {
            log("Started $i")
            delay(100) // 假装我们以消耗 CPU 的方式进行计算
            emit(i)
        }
    }.flowOn(Dispatchers.IO)


    fun CoroutineScope.productNumber() = produce<Int> {
        var x = 1
        while (true){
            send(x++)
        }
    }

    fun CoroutineScope.square(numbers: ReceiveChannel<Int>) : ReceiveChannel<Int> = produce {
        for(x in numbers){
            send(x * x)
        }
    }

}