package com.cp.helloworldx.design_pattern

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * 代理模式
 * 说明: 不改变原始类和不使用继承的情况下，通过引入代理对象来给原始类附加功能
 * 场景: 增加代理访问，比如 监控、缓存、限流、事务、RPC
 *  为其他对象提供一种代理以控制对这个对象的访问
 *
 * 与装饰者区别 代理模式 构造方法里面 New了一个被代理的对象 不是调用者传入，装饰者是调用者从外部传入被装饰的对象 将功能加强一下
 *
 *
 * 远程代理 ：为位于两个不同地址空间对象的访问提供了一种实现机制，可以将一些消耗资源较多的对象和操作移至性能更好的计算机上，提高系统的整体运行效率。
 * 虚拟代理：通过一个消耗资源较少的对象来代表一个消耗资源较多的对象，可以在一定程度上节省系统的运行开销。
 * 缓冲代理：为某一个操作的结果提供临时的缓存存储空间，以便在后续使用中能够共享这些结果，优化系统性能，缩短执行时间。
 * 保护代理：可以控制对一个对象的访问权限，为不同用户提供不同级别的使用权限。
 * 智能引用：要为一个对象的访问（引用）提供一些额外的操作时可以使用
 *
 *  场景: 日志功能 需要给每个使用这个类的地方 增加日志
 */
public class ComposeProxyPattern {


    /**
     * 使用PeopleX 需要诉讼,请律师 代理诉讼为例
     */
    public fun test(){
        //静态代理 已经固定了代理对象
        ProxyFactory.getProxy().submit("11122")

        //动态代理 不固定代理对象
        var proxy : ILawSuit= ProxyFactory.getDynProxy(PeopleX()) as ILawSuit
        proxy.submit("22233")
    }
    /**
     * 定义接口
     */
    public interface ILawSuit{
        fun submit(proof:String)//提起诉讼
        fun defend() //法庭辩护
    }


    /**
     *
     */
    public class PeopleX : ILawSuit{
        override fun submit(proof: String) {
            print(String.format("老板欠薪跑路，证据如下：%s",proof));
        }

        override fun defend() {
            print(String.format("铁证如山，%s还钱","马旭"));
        }

    }


    /**
     * 静态代理
     */
    public class ProxyLawyer(var plaintiff : ILawSuit) : ILawSuit{
        override fun submit(proof: String) {
            //做一些自己的事情
            plaintiff.submit(proof)
        }

        override fun defend() {
            plaintiff.defend()
        }

    }


    public class DynProxyLawyer(var target : Any?) : InvocationHandler{

        override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any {
            if(method?.name.equals("submit")){
                // do sothing
                var result = method?.invoke(target,  args)
            }
            var result = method?.invoke(target,  args)

            return result!!
        }

    }


    public class ProxyFactory{

        companion object{
            fun getProxy(): ProxyLawyer {
                return ProxyLawyer(PeopleX())
            }

            fun getDynProxy( target: Any): Any {
                var handler = DynProxyLawyer(target)
                return Proxy.newProxyInstance(target.javaClass.classLoader,target.javaClass.interfaces,handler)
            }
        }
    }
}