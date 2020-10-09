package com.cp.helloworldx.design_pattern

public class CreatorSingleton{

    fun testA(){
        SingletonDemo2.instance
    }

    /**
     * 懒汉式  相当于
     * public class SingletonDemo {
        private static SingletonDemo instance=new SingletonDemo();
        private SingletonDemo(){

            }
         public static SingletonDemo getInstance(){
            return instance;
         }
            }
     */
    object SingletonDemo{

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