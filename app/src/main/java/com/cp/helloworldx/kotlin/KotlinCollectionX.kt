package com.cp.helloworldx.kotlin

import java.util.*


object KotlinCollectionX {
    class Person(var name: String)
    @JvmStatic
    fun main(args: Array<String>) {
        val numbersMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
        numbersMap.remove("one")
        println(numbersMap)
        println(numbersMap)
    }
    /**
     * 集合类  List Map
     */
    fun ListX() {
        //初始化
        val initList = listOf<String>()
        val mutableList = mutableListOf<String>()
        val numberMuList = mutableListOf("one", "two", "three", "four")
        val numberList = listOf("one", "two", "three", "four")
        //取值  安全取值
        numberMuList.getOrElse(1) { "default" }
        numberMuList.getOrNull(1)
        val size = numberMuList?.size ?: 0
        var firstList = numberMuList.take(2)  //取前两个List的值
        var lastList = numberMuList.takeLast(2) //取后两个list的值
        var subList = numberMuList.subList(3,6) //取3到5

        //查找
        var index = numberMuList.indexOf("2")
        var index2 = numberMuList.indexOfFirst { it == "2" }
        var index3 = numberMuList.indexOfLast { it == "2" }

        //排序  原数据源不改变
        val sortedNumbers1 = numberMuList.sorted()
        //原数据源改变
        val sortedNumbers2 = numberMuList.sort()

        //浅拷贝  add remove 不影响， 里面元素内容改变影响
        val copyList = numberList.toMutableList()


        // 过滤
        val filterResults = mutableListOf<String>()
        //将item内容筛选后 add到 filterResults中
        numberMuList.filterTo(filterResults) { it.length > 3 }
        numberMuList.filterIndexedTo(filterResults) { index, _ -> index == 0 }
        // 将数字直接过滤到新的哈希集中，
        // 从而消除结果中的重复项
        val result = numberMuList.mapTo(HashSet()) { it.length }

        for (item in numberMuList) {

        }

        //检测元素是否在集合中
        if ("2222" in numberMuList) {
        }

        //
        numberMuList
            .filter {it -> it.startsWith("a") }
            .sortedBy { it } //按字母排序
            .map { it.toUpperCase() }
            .forEach { it } //遍历集合
    }

    fun setX(){
        //映射转换从一个集合  创建一个集合
        val setOfList = setOf(1, 2, 3)
        //转换
        setOfList.toMutableList()

        setOfList.map { it  }
        setOfList.mapIndexed { idx, value -> idx }
        //替换掉Null
        setOfList.map { if ( it == 2) null else it * 3 }
        setOfList.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx }
    }

    /**
     * map
     */

    fun mapX(){
        //map 默认实现是LinedHashMap 保留拆入顺序， 另外一种HashMap 不申明循序
        //创建
        val numbersMap = mapOf("key1" to 1, "key2" to 2)


        //寻找key
        if("key1" in numbersMap){
            println("value by key ${numbersMap["key1"]}")
        }

        //寻找value
        if(2 in numbersMap.values){}
        if(numbersMap.containsValue(1)){}

        val map = mutableMapOf<String, String>()
        map.getValue("11")//直接通过getValue获取,如果key 没有会报错
        map.getOrElse("11", { "ss" })//直接通过getValue获取,如果key 没有会报错

        for((k,v) in map){
            println("$k->$v")
        }
    }

}