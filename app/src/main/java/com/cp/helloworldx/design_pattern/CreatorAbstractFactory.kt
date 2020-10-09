package com.cp.helloworldx.design_pattern

/**
 * 抽象工厂模式
 * 和工厂模式比 抽象出工厂创建方法 来创建工厂
 * 提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式又称为Kit模式，属于对象创建型模式，是工厂方法模式的升级版，
 *
 * 在有多个业务品种、业务分类时，
 * 通过抽象工厂模式产生需要的对象是一种非常好的解决方式。
   使用场景:  1、QQ 换皮肤，一整套一起换。 2、生成不同操作系统的程序。

抽象工厂模式包含了几个角色：

AbstractFactory：用于声明生成抽象产品的方法

ConcreteFactory：实现了抽象工厂声明的生成抽象产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中；

AbstractProduct：为每种产品声明接口，在抽象产品中定义了产品的抽象业务方法；

Product：定义具体工厂生产的具体产品对象，实现抽象产品接口中定义的业务方法。
 *
 */
public class CreatorAbstractFactory {

    public fun testA() {
        val creator1 = Creator1()
        creator1.createProductA().doSomething();
        creator1.createProductB().doSomething();


        val creator2 = Creator1()
        creator2.createProductA().doSomething();
        creator2.createProductB().doSomething();
    }

    public class Creator1 : AbstractCreator() {
        override fun createProductA(): AbstractProductA {
            return ProductA1()
        }

        override fun createProductB(): AbstractProductB {
            return ProductB1()
        }

    }

    public class Creator2 : AbstractCreator() {
        override fun createProductA(): AbstractProductA {
            return ProductA2()
        }

        override fun createProductB(): AbstractProductB {
            return ProductB2()
        }

    }



    public abstract class AbstractCreator {
        abstract fun createProductA(): AbstractProductA
        abstract fun createProductB(): AbstractProductB

    }

    public abstract class AbstractProductA {
        public fun shareMethod() {}

        public abstract fun doSomething()
    }


    public abstract class AbstractProductB {
        public fun shareMethod() {}

        public abstract fun doSomething()
    }


    public class ProductA1 : AbstractProductA() {
        override fun doSomething() {
        }

    }

    public class ProductA2 : AbstractProductA() {
        override fun doSomething() {
            TODO("Not yet implemented")
        }

    }


    public class ProductB1 : AbstractProductB() {
        override fun doSomething() {
            TODO("Not yet implemented")
        }

    }

    public class ProductB2 : AbstractProductB() {
        override fun doSomething() {
            TODO("Not yet implemented")
        }

    }


}