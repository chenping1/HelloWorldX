package com.cp.helloworldx.design_pattern

/**
 * 命令行模式
 * 说明: 将不同的请求 封装在对应的命令对象，对命令的执行进行控制且使用方透明
 * 场景: 用于控制命令的执行， 比如 异步 延迟、  排队 、 撤销、 存储、 撤销
 * 用来解耦的，通常是请求者和实现者是一种耦合关系
 *
 *
 */
class BehaviorCommandPattern {
    public interface Order{
    }
}