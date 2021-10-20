package com.cp.helloworldx.kotlin

import android.content.Context
import android.view.View
import android.widget.Toast

class KotlinX {
    //延迟申明属性 一般可用于注解后申明的如ButterKnife
    lateinit var a: String


    fun nullX() {

        var b: String? = "abc"
        b?.length //如果b为null，返回null，否则返回b.length
        b!!.length //如果b为null，抛出空指针异常，否则返回b.length
        var c = b!! //b为空 报错
        var d = b ?: "2"


        var name: String? = ""
        var people: String = name!!

        //一个小知识点,当列表为空时赋值0
        val nameList: MutableList<String>? = null
        val size = nameList?.size ?: 0

        // 如果该值或其转换结果为空，那么返回 defaultValue。
        val mapped = name?.let { it.replace("sss","") } ?: "sa"
    }

    /**
     * 类型转换 类型判断
     */
    fun typeX(obj: Any) {
        //类型检测
        if (obj is String) {
            obj.length
        }

        //安全类型转换 如果obj 为Int 则转成int 不是则为null
        val aInt: Int? = obj as? Int
    }


    /**
     * 字符串类
     */
    fun stringX() {
        val a = 1

        val s1 = "a = $a"

        //使用{} 括起来的字符串模板
        val s2 = "${s1.replace("is", "was")}, but now is $a"

    }

    /**
     * 扩展函数
     */
    fun String?.toNonNullString(): String {
        return if (this.isNullOrEmpty()) "-" else this
    }

    fun forWhenX() {
        val items = listOf("apple")
        for (item in items) {

        }

        //检测元素是否在集合中
        if("2222" in items){
        }
    }

    fun <T> getName(t : T){

    }

    /**
     * 集合类  List Map
     */
    fun collectionX() {
        val item1 = listOf<String>()
        val list = listOf("apple")

        var item = list.take(2)  //取前两个List的值
        var item2 = list.takeLast(2) //取后两个list的值

        val mutableList = mutableListOf<String>()


        //lambda
        item1
                .filter {it -> it.startsWith("a") }
                .sortedBy { it } //按字母排序
                .map { it.toUpperCase() }
                .forEach { it } //遍历集合

        val map = mutableMapOf<String, String>()

        map.getValue("11")//直接通过getValue获取,如果key 没有会报错
        map.getOrElse("11", { "ss" })//直接通过getValue获取,如果key 没有会报错

        for((k,v) in map){
            println("$k->$v")
        }
    }

    /**
     * let 适用于处理不为null的操作场景
     * with 适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法
     * run 适用于let,with函数任何场景。
     * apply 通run 返回值是本身 场景:对象实例化需要赋值处理 链式调用
     * also 同let,区别返回值是本身  场景:链式调用
     */
    fun letWithRunApplyAlsoX() {
        //let  用于可null 对象统一处理 2.明确一个变量特定作用访问内可以使用 3.返回值是最后一行 或return
        val result = "resultLet".let {
            print(it.length)
            1000
        }
        print(result) //打印为1000

        //with  适用于调用同一个类多个方法时， 可以省去类名重复  经常用于Adapter里面的 onBinderViewHolder model隐射到UI中
        val withX = ClassX("A")
        with(withX) {
            testA()
            testB()
        }

        //run let with 结合体  可以替换掉let with 返回值最后一行
        val runX = ClassX("A")
        runX.run {
            testA()
            testB()
        }

        //apply 与run 区别是返回值是自身
        //使用场景 1. 对象实例话需要对自身属性赋值或者inflat 一个xml 需要绑定数据
        //       2. 多级判空  多个扩展函数链式调用
        //mSheetDialogView = View.inflate(activity, R.layout.biz_exam_plan_layout_sheet_inner, null).apply{
        //course_comment_tv_label.paint.isFakeBoldText = true
        //course_comment_tv_score.paint.isFakeBoldText = true
        //}

        //       2. 多级判空
//        mSectionMetaData?.apply{//mSectionMetaData不为空的时候操作mSectionMetaData
//        }?.questionnaire?.apply{ //questionnaire不为空的时候操作questionnaire
//        }?.section?.apply{//section不为空的时候操作section
//        }?.sectionArticle?.apply{//sectionArticle不为空的时候操作sectionArticle
//        }

        //also
        //和let 相似 ，返回值是本身  用于函数多个扩展函数链式调用
        withX.also {
            it.testA()
        }.also {
            it.testB()
        }

    }

    /**
     * 类
     */
    class ClassX(val name: String) : BaseX(name) { //参数就是构造函数   //继承必须显示的传递构造函数

        //1 次构造函数必须通过this委托给主构造
        //2 次构造函数 里面的内容 在 init 之后调用
        constructor(name: String, age: String) : this(name) {

        }


        //实例化的时候 init 和 类里的申明 按照代码顺序执行 init 可以有多个
        init {
            val hello = name
        }

        init {

        }

        fun testA() {
            var test = name
        }

        fun testB() {
            var test = name
        }

        fun testC(){
            //匿名内部类object :
            object : A{
                override fun testA() {
                    TODO("Not yet implemented")
                }

            }

            C.testC()
        }
    }

    open class BaseX(name: String) {

    }


    /**--------------****/
    interface A{
        fun  testA()
    }

    /**
     * 单例
     */
    object C{
        fun testC(){

        }
    }

    // 实例话
    companion object {
        @JvmStatic
        fun newInstance(): ClassX {
            return ClassX("A")
        }
    }
}