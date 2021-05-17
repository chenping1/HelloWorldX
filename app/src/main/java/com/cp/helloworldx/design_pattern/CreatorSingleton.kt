package com.cp.helloworldx.design_pattern

/**
 * 单例
 * 说明: 一个类只允许创建一个实例或对象， 并为其提供一个全局的访问点
 * 适用场景: 内存中只有一个实例 减少开销
 *
 * 无状态/全局唯一/控制资源访问
 * 实现: 1. 懒汉式  静态方法 用的时候再实例化
 *       2. 饿汉式 静态变量 直接new出对象
 */
public class CreatorSingleton{

    fun testA(){
        SingletonDemo2.instance
    }


    object SingletonDemo{

    }

    public abstract class Singleton<T>{

         var mInstance : T? = null
            abstract fun create() : T

        fun get(): T? {
            synchronized(this){
                if(mInstance == null){
                    mInstance = create()
                }
                return mInstance
            }
        }
    }

    /**
     * 线程安全的懒汉式
     */
    class SingletonDemo2{

        companion object{
            var instance:SingletonDemo2 ? =null


            get() {
                if(field == null){
                    field = SingletonDemo2()
                }
                return field
            }

            @Synchronized //线程安全的
            fun get():SingletonDemo2{
                return instance!!
            }
        }
    }


    /**
     *  双重校验锁式
     */
    class SingletonDemo3 private constructor(){

        companion object{
            val instance: SingletonDemo3 by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED){
                SingletonDemo3()
            }
        }
    }
}