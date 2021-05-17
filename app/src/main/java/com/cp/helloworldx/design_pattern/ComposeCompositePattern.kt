package com.cp.helloworldx.design_pattern

/**
 * 组合模式
 * 说明: 将对象组合成树形结构以表示‘部分-整体’的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。
 * 场景: 满足部分和整体 这种树形结构
 * 示例: 树中 一个节点可以是根节点 可以是叶子节点
 * Android view和ViewGroup的关系 ViewGroup可以是一个View 又可以包含View
 */
public class ComposeCompositePattern {

    public class ListNode{
        var data : Int = 0
        var left:ListNode? = null
        var right:ListNode? = null
    }

}