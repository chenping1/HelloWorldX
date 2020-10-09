package com.cp.helloworldx.design_pattern

/**
 *   原型模式
 */
public class CreateClonePattern{
    data class DataItem(val name:String)
    fun test(){
        val abc = DataItem("22")

        val xyz = abc.copy()
    }
}