### Java 集合系列

### 集合和继承关系
* Collection
    * List
        * ArraryList
        * LinkedList
        * Verctor
            *Stack
    * Set
* Map
    * HashMap
    * linkedhashmap
    * WeakHashMap
    * Hashtable



！1、列举几个Java中Collection类库中的常用类
！2、List、Set、Map是否都继承自Collection接口？存储特点分别是什么？

常用集合类的使用、ArrayList 和 LinkedList 和 Vector 的区别 、SynchronizedList 和 Vector 的区别、HashMap、HashTable、ConcurrentHashMap 区别、

Set 和 List 区别？Set 如何保证元素不重复？

 ！3、ArrayList、LinkedList和Vector之间的区别与联系
！4、HashMap和Hashtable、TreeMap以及ConcurrentHashMap的区别
！5、Collection 和 Collections的区别


### arraylist-linkedlist-vector的区别
- ArrayList 基于动态数组的数据结构  get set有优势  线程不同步不过性能好
- LinkedList 基于链表的数据结构  新增和删除有优势
- Vector 基于数据的数据结构  线程同步

### hashmap和hashtable区别
1. 继承和实现区别 HashMap继承AbstractMap；Hashtable继承了Dictionary
2. 线程安全不同 HashMap是不同步的 多线程情况下需手动同步 ,HashTable方法是同步的
3. 
3. 对null处理不同 HashTable不允许null值, HashMap允许 这是因为HashMap对null进行了特殊处理，将null的hashCode值定为了0，从而将其存放在哈希表的第0个bucket。

###  hashmap与arraymap和sparearray对比
https://blog.csdn.net/u010687392/article/details/47809295

Hasmap内部是 数组+ 链表

SpareArray 内部是 两个数组,key 必须为int 型， 可以替换HashMap 为数据量不要大 前级别,

ArrayMap 跟SpareArray 一样是两个数组，内部使用

Arrays.asList 获得的 List 使用时需要注意什么