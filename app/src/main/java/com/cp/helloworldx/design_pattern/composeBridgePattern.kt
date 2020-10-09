package com.cp.helloworldx.design_pattern

/**
 * 桥接模式
 * 将抽象部分与实现部分分离，使它们都可以独立的变化。
 */
public class composeBridgePattern {

    public fun test(){
        var man = Man(Jacket())
        man.dress()

        man = Man(SleepCoat())

        man.dress()
    }
    public abstract class Finery {
        public abstract fun dress()
    }

    public class Jacket : Finery() {
        override fun dress() {
            print("外套")
        }

    }

    public class SleepCoat : Finery() {
        override fun dress() {
            print("睡衣")
        }

    }

    public class TShirt : Finery() {
        override fun dress() {
            print("T 袖")
        }
    }

    public class Man(var finery: Finery) {

        public fun dress() {
            finery.dress()
        }
    }
}