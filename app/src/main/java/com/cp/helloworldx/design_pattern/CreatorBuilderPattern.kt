package com.cp.helloworldx.design_pattern

/**
 * 建造者模式
 * 说明: 用于 创建一个可配置复杂的对象，通过设置不同的可选参数 定制化
 * 使用场景: 对象的构造参数较多 且多数可选 --
 *
 * 链式调用
 */
public class CreatorBuilderPattern{


    public class Dialog(){
        var title : String? = null;
        var mCancelable : Boolean? =null

        public fun show(){
            print("title")
        }

        class Builder{
            private var title : String? = null;
            var mCancelable : Boolean? =null

            fun setTitle(title : String?) : Builder{
                this.title = title
                return this
            }

            fun setCancelable(cancelable : Boolean?) : Builder{
                this.mCancelable = cancelable
                return this
            }


            open fun build() : Dialog{
                var dialog = Dialog()
                dialog.title = this.title
                dialog.mCancelable = this.mCancelable
                return dialog
            }
        }
    }


}