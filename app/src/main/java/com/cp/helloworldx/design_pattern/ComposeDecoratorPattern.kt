package com.cp.helloworldx.design_pattern


/**
 * 结构型--装饰模式
 * 是在不必改变原类和使用继承的情况下，动态地扩展一个对象的功能。它是通过创建一个包装对象，也就是装饰来包裹真实的对象
 * 场景:
 * 1. 需要动态给一个对象增加额外职责
 * 2. 给一个类增加职则 又不想通过继承的方式来实现(组合优先继承)
 *
 */
public class ComposeDecoratorPattern {

    public fun test(){
        var coffee: ICoffee = OriginalCoffee()
        coffee.makeCoffee();// 原味咖啡

        coffee = MilkDecorator(coffee)
        coffee.makeCoffee();//加奶咖啡

        coffee = SugarDecorator(coffee)
        coffee.makeCoffee();//先加奶再加糖咖啡
    }

    /**
     * 第一步：先声明一个原始对象的接口
     */
    public interface ICoffee {
        fun makeCoffee()
    }

    /**
     * 第二步：构建我们的原始对象，此处为原味咖啡对象，它实现了ICoffee接口。
     */
    public class OriginalCoffee : ICoffee {
        override fun makeCoffee() {
            print("原味咖啡")
        }

    }

    /**
     * 第三步：构建装饰者抽象基类，它要实现与原始对象相同的接口ICoffee，其内部持有一个ICoffee类型的引用，用来接收被装饰的对象
     */
    public abstract class CoffeeDecorator(var coffee: ICoffee) : ICoffee {
        override fun makeCoffee() {
            coffee.makeCoffee()
        }
    }


    /**
     * 第四步：构建各种装饰者类，他们都继承至装饰者基类 CoffeeDecorator。此处生成了两个，一个是加奶的装饰者,另一个是加糖的装饰者。
     */
    public class MilkDecorator(coffee: ICoffee) : CoffeeDecorator(coffee) {

        override fun makeCoffee() {
            super.makeCoffee()
            addMilk()
        }

        private fun addMilk() {
            print("addMilk")
        }
    }

    public class SugarDecorator(coffee: ICoffee) :CoffeeDecorator(coffee){
        override fun makeCoffee() {
            super.makeCoffee()
            addSugar()
        }

        private fun addSugar() {
            print("addSugar")
        }
    }
}