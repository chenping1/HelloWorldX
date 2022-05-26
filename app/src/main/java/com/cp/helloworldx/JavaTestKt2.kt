package com.cp.helloworldx

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.*
import kotlin.jvm.JvmStatic

object JavaTestKt2 {

    @JvmStatic
    fun main(args: Array<String>) {

        val numbers = setOf("one", "two", "three", "four")

        println(numbers union setOf("four", "five"))
        println(setOf("four", "five") union numbers)

        println(numbers intersect setOf("two", "one"))
        println(numbers subtract setOf("three", "four"))
        println(numbers subtract setOf("four", "three")) // 相同的输出

    }

    fun isOdd(x: Int) = x % 2 != 0


    fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
        return { x -> f(g(x)) }
    }

    var x = 1
}