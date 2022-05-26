package com.cp.helloworldx.kotlin

import kotlin.properties.Delegates

object KotlinHigherX {
    //延迟申明属性 一般可用于注解后申明的如ButterKnife
    lateinit var a: String

    //延迟初始化属性， 只能是 val, 运行一次后就把值保存下来  下次直接获取
    val lazyValue: String by lazy {
        println("print lzay")
        "hello"
    }

    //可观察的数据
    var name: String by Delegates.observable("init name") { pop, old, new ->
        println("$old->$new")
    }

    /** 委托 **/
    interface IBy {
        fun print()
    }

    class ByImplA : IBy {
        override fun print() {
            print("bbbb");
        }

    }

    class ByImplB(b: IBy) : IBy by b {
        fun test() {

        }
    }

    fun testBy() {
        var implA = ByImplA()
        ByImplB(implA).print()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        //测试可观察数据
        /*name = "first"
        name = "second"*/
        testBy()
    }


    /** 内联 函数**/
    fun box() {

        a.det {

        }
    }


    inline fun <reified T, R> T.det(block: (T) -> R): R {
        var a = 1
        if (a is T) {

        }

        return block(this)
    }


    //[Kotlin泛型](https://juejin.cn/post/6950042154496425992)
    //[泛型七连问](https://juejin.cn/post/6978833860284907527)



}