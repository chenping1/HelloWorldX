package com.cp.helloworldx.design_pattern;


/**
 * 面向对象设计六大原则
 * 1. 单一职责  (一个类只负责一个职责  )
 * 2. 开闭原则  (一个软件实体应当对扩展开放，对修改关闭。 尽量在不修改原有代码的情况下进行扩展(继承) -Base基类 定义一个相对稳定的抽象层 通过接口或抽象将可变因素)
 * 3. 里氏替换原则 (将父类使用的地方都替换成子类 依然可以工作 ，子类除了添加新增功能外 不要重写已经实现的方法)
 * 4. 依赖倒置  (针对接口编程  不依赖于具体实现 利于代码升级)
 * 5. 接口隔离原则  (使用多个专门的接口 而不是使用单一的总接口) 使功能高内聚低耦合
 * 6. 迪米特原则  (一个软件实体尽可能 少与外部发生作用, 少暴露公共方法和类 )
 * 7. 合成复用原则 (使用对象组合 而不是继承的方式达到目的)
 *
 * 23 种设计模式
 * 1.创建型 提供 对象实例，同时隐藏创建逻辑的方式，而不是使用 new 运算符直接实例化对象  5
 * @see CreatorSingleton 创建型_单例
 * @see CreatorSimpleFactory 创建型_简单工厂
 * @see CreatorAbstractFactory 创建型_抽象工厂
 * @see CreatorBuilderPattern 创建型_建造者模式
 * @see CreateClonePattern 创建型_原型模式
 * 2. 结构型 关注如何将现有类或对象组织在一起形成更加强大的结构 8
 * @see ComposeProxyPattern 结构型_代理模式  和装饰者区别
 * @see ComposeDecoratorPattern 结构型_装饰者模式
 * @see ComposeCompositePattern 结构型_组合模式
 * @see ComposeBridgePattern  结构型_桥接模式
 * @see ComposeCompositePattern 结构型_组合模式
 * @see ComposeAdapterPattern 结构型_适配器模式
 * @see ComposeFacadePattern 结构型_外观模式
 * @see ComposeFlyweightPattern 结构型_享元模式
 *3. 行为型  描述类或对象的交互及职责分配 ， 运行时复杂流程控制 关注对象之间的通信 10
 * @see BehaviorObserverPattern 观察者模式
 * @see BehaviorTemplatePattern 模板模式
 * @see BehaviorStrategyPattern 策略模式
 * @see BehaviorStatePattern 状态模式
 * @see BehaviorChainOfResponsibilityPattern 责任链模式
 * @see BehaviorMementoPattern 备忘录模式
 * @see BehaviorCommandPattern 命令行模式
 * @see BehaviorInterpreterPattern 解释器模式
 * @see BehaviorIteratorPattern 迭代器模式
 * @see BehaviorMediatorPattern 中介者模式
 * @see BehaviorVisitorPattern 访问模式
 */
public class _DPX {

    public static void start(){

        new CreatorBuilderPattern.Dialog.Builder().setTitle("11").build().show();
    }

}
