package com.cp.helloworldx.design_pattern

/**
 * 访问者模式
 * 解决稳定的数据结构和易变的操作 耦合问题
 * 一个动作的抽象类，图片系统和相机系统完成了这个动作。App1 实现了访问者接口，表示App1可以 访问 图片系统和相机系统。
再换个例子，比如棉花和纸,在做衣服的工厂可以做成毛衣和标签牌子，在造钱的工厂,可以做成纸币和包装袋
访问者的目的是：稳定的数据结构 和 异变的操作 ，耦合问题，我觉着应该不用在解释了。

 */
public class BehaviorVisitorPattern {

    public fun test(){
        var app1 = App1()
        var imageSystem = ImageSystem();
        imageSystem.accept(app1)
    }


    public abstract class Action{
        abstract fun accept(visitor: Visitor)
    }

    public class ImageSystem: Action() {
        override fun accept(visitor: Visitor) {
            visitor.visitor(this)
        }

    }

    public class CameraSystem : Action(){
        override fun accept(visitor: Visitor) {
            visitor.visitor(this)
        }

    }
    public interface Visitor{
        fun visitor(imageSystem: ImageSystem)
        fun visitor(cameraSystem: CameraSystem)
    }

    public class App1 : Visitor{
        override fun visitor(imageSystem: ImageSystem) {
            print("访问图片")
        }

        override fun visitor(cameraSystem: CameraSystem) {
            print("访问相机")
        }

    }
}