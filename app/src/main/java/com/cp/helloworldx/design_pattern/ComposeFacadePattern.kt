package com.cp.helloworldx.design_pattern

/**
 *  外观(门面)模式
 *  为子系统中一组接口定义一个更高层的接口， 使得子系统更加容易使用    将功能聚合到一个类中
 *  目的:解决接口复用(细粒度)与接口易用性(粗粒度)的矛盾   降低系统复杂性
 *  示例: 遥控器 既可以开电视 又可以开灯 。职责不单一 ，比如android中的context 既可以打开Activity又可以打开Service
 *
 */

public class ComposeFacadePattern {
    public interface Action{
        fun open()
    }

    public class Lamp : Action{
        override fun open() {
            print("开灯")
        }
    }

    public class TV :Action{
        override fun open() {
            print("开电视")
        }

    }

    public class RemoteControl{
        lateinit var lamp:Action;
        lateinit var tv:Action

        constructor(lamp: Action, tv: Action) {
            this.lamp = lamp
            this.tv = tv
        }

        public fun openLamp(){
            lamp.open()
        }

        public fun openTV(){
            tv.open()
        }
    }
}
