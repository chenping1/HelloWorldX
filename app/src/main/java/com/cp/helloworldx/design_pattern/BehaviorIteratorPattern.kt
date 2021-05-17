package com.cp.helloworldx.design_pattern

/**
 * 迭代器模式
 * 说明: 提供一种方法顺序访问一个集合对象的各个元素，但不暴露改对象的内部标识
 * 场景: 解耦集合对象的内部表示与遍历访问
 * 遍历一个对象
 * 访问一个聚合数据，聚合数据不会暴露内部内容
 *
 */
class BehaviorIteratorPattern {

    public fun test(){
        var it = NameContainer().getIterator()
        while(it.hasNext()){
            val name = it.next()
        }
    }
   public interface Iterator{
       fun hasNext() : Boolean
       fun next() : Any?
   }

    public interface Container{
        fun getIterator():Iterator
    }

    public class NameContainer : Container{
        public var names : Array<String> = arrayOf("11","2","3")

        override fun getIterator(): Iterator {
            return NameIterator()
        }

        inner class NameIterator : Iterator{
            var index = 0

            override fun hasNext(): Boolean {
                return index < names.size
            }

            override fun next(): Any? {
                if(this.hasNext()){
                    return names[index]
                }
                return null
            }

        }
    }


}