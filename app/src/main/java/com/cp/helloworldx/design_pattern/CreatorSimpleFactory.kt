package com.cp.helloworldx.design_pattern


/**
 * 创建型模式 -- 接入支付功能
 * 1. 接口或者基类  抽象出 抽象方法 2. 子类继承实现，  3.创建一个工厂，生成基于给定信息的实体类的对象。
 * 简单工厂模式是一种创建型模式，又叫做静态工厂方法模式。
 * 它的定义为：定义一个用于创建对象的接口，让子类决定实例化那个类。
 * 在简单工厂模式中，可以根据参数的不同返回不同类的实例。
 */
class CreatorSimpleFactory {
    fun test(){
        val payChannel : PayChannel? = DemoFactory.getPayChannel(AliyPay::class.java)
        payChannel?.pay()


        val payChannel2 : PayChannel? = DemoFactory.getPayChannel("aliy")
        payChannel2?.pay()
    }


    class DemoFactory{
        companion object {
            /**
             * 方式一 通过传参type 控制
             */
            fun getPayChannel(payType: String?): PayChannel? {
                var payChannel: PayChannel? = null
                when (payType) {
                    "wechat" -> payChannel = WechatPay()
                    "aliy" -> payChannel = AliyPay()
//            "union" -> payChannel = UnionPay()
                }
                return payChannel
            }


            /**
             * 方式二 通过放射控制
             */
            fun getPayChannel(clz: Class<out PayChannel?>): PayChannel? {
                var payChannel: PayChannel? = null
                try {
                    payChannel = Class.forName(clz.name).newInstance() as PayChannel
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                return payChannel
            }
        }
    }



    abstract class PayChannel {
        abstract fun pay()
    }

    public class AliyPay : PayChannel() {
        override fun pay() {
            TODO("Not yet implemented")
        }

    }


    public class WechatPay : PayChannel() {
        override fun pay() {
            TODO("Not yet implemented")
        }

    }


}