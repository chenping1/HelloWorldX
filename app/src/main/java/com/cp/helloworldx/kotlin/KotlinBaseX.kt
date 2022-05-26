package com.cp.helloworldx.kotlin

object KotlinBaseX {
    //Kotlin基础 https://juejin.cn/post/6942251919662383134

    fun String?.toEmptyString(): String {
        return if (this.isNullOrEmpty()) "" else this
    }
    fun List<String>?.toSeparatorString() : String{
        return this?.joinToString(",").toEmptyString()
    }
    @JvmStatic
    fun main(args: Array<String>) {
        var list = mutableListOf<String>("1","2")

        println(list.toSeparatorString())
    }

    fun BaseX() {
        var b: String? = "abc"
        var d = b ?: "2"  //b 为空 则赋值默认值
        // 如果该值或其转换结果为空，那么返回 defaultValue。
        val mapped = b?.let { b.replace("sss", "") } ?: "sa"

        //字符串
        val a = 1
        val s1 = "a = $a"
        //使用{} 括起来的字符串模板
        val s2 = "${s1.replace("is", "was")}, but now is $a"


        //类型转换
        var obj: Any = "aaa"
        if (obj is String) { //判断类型 相当于instance of
            obj.length
        }
        //安全类型转换 如果obj 为Int 则转成int 不是则为null
        val aInt: Int? = obj as? Int

        //常量 const 只能定义在 object, companion object , 顶层函数里

        //序列化
        /*dataList = Gson().fromJson(GsonUtils.toJson(originDataList),
            object : TypeToken<MutableList<RelationShipBillVO>?>() {}.type
        )*/
    }

    /**
     * 函数
     * 1. 带默认值的 函数， 如果参数是默认值 可以省略
     * 2. @JvmStatic 和 顶层方法 是java 中静态方法， object和companion object 里面的方法不是真正静态的
     */
    fun defaultParamFunX(paramsA: String = "aaa", paramsB: String = "aaa"){
        println(paramsA)
    }
    /**
     * 扩展函数
     */
    fun String?.toNonNullString(): String {
        return if (this.isNullOrEmpty()) "-" else this
    }


    fun <T> getName(t: T) {

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

        //相当于java 静态方法 外界直接通过 ClassX.TAG 调用
        companion object{
            val TAG = "companion object"
        }

        //1 次构造函数必须通过this委托给主构造
        //2 次构造函数 里面的内容 在 init 之后调用
        constructor(name: String, age: String) : this(name) {
        }

        //实例化的时候 init 和 类里的申明 按照代码顺序执行 init 可以有多个
        init {
            val hello = name
        }

        fun testA() {

        }

        fun testB() {
            var test = name
        }

        fun testC() {
            //匿名内部类object :
            val imple = object : A {
                override fun testA() {
                    println("sss")
                }
            }
            imple.testA()

            //对比上面的 函数式lambda 表达式
            val impleB = B{
                println("sss")
            }

        }


        /**
         * 中缀表达式
         * 1、必须是成员函数或扩展函数
            2、必须只有一个参数
            3、参数不可能是可变参数或默认参数
         */
        infix fun hello(name:String){
            println(name)
        }
    }

    open class BaseX(name: String) {

    }
    interface A {
        fun testA()
    }

    /**
     * 只有一个抽象方法  函数函数式接口 ， 注意前面有个fun
     */
    fun interface B{
        fun testA()
    }

}

