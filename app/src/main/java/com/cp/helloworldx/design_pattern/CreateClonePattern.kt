package com.cp.helloworldx.design_pattern

/**
 *   原型模式
 *   说明: 通过复制已有对象来创建新的对象
 *   使用场景: 对象的成本较大且同一类的不同对象之前差别不大
 */
public class CreateClonePattern{
    data class DataItem(val name:String)
    fun test(){
        val abc = DataItem("22")

        val xyz = abc.copy()
    }
}