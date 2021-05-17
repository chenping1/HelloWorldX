package com.cp.helloworldx.design_pattern

/**
 * 桥接模式
 * 说明: 将抽象部分与实现部分分离，使它们都可以独立的变化。
 * 场景: 适用于 业务需要像两个维度扩展
 *
 * 1.、示例 如果要绘制 不同形状， 每个形状又有不同的颜色
 × 将形状抽象为抽象类， 颜色作为接口  ,这样就是两个不同可变抽象
 */
public class ComposeBridgePattern {

    public fun test() {
        var circularShape = CircularShapeImpl(RedColor(),2)
        circularShape.draw()

        var rectangleShape = RectangleShapeImpl(WhiteColor(),1,2)
        rectangleShape.draw()
    }

    /**
     * 定义颜色接口
     */
    public interface Color {
        fun getColor();
    }

    /**
     * 颜色实现类
     */
    public class RedColor : Color {
        override fun getColor() {
            print("红色")
        }

    }

    /**
     * 颜色实现类
     */
    public class WhiteColor:Color{
        override fun getColor() {
            print("白色")
        }

    }

    /**
     * 桥接模式抽象类
     */
    public abstract class Shape(var color:Color) {

        public abstract fun draw()
    }

    public class RectangleShapeImpl(color:Color,x : Int, y:Int) : Shape(color) {

        override fun draw() {
            print("矩形，颜色="+ color.getColor());
        }

    }

    public class CircularShapeImpl(color: Color, r:Int) : Shape(color) {
        override fun draw() {
            print("矩形，颜色="+ color.getColor());
        }

    }


}