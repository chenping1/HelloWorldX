package com.cp.helloworldx.design_pattern


/**
 * 行为模式--策略模式
 * 策略模式定义了一系列的算法，并将每一个算法封装起来，使他们可以相互替换
 */
public class BehaviorStrategyPattern {

    public fun test(){
        var calculator:TrafficFeeCalculator = TrafficFeeCalculator()
        calculator.gotoTianJinEye(ByBus(),100)

        calculator.gotoTianJinEye(ByDiDiExpress(),200)
    }
    /**
     * 第一步：封装不同的实现算法
     */
    public interface CalculateStrategy{
        fun calculateTrafficFee(distance:Int) : Int
    }

    /**
     * 第二步：封装各个算法
     */
    public class ByBus : CalculateStrategy{
        override fun calculateTrafficFee(distance: Int): Int {
            return if (distance < 10) 4 else 6
        }
    }

    //乘坐滴滴快车算法
    class ByDiDiExpress : CalculateStrategy {
        override fun calculateTrafficFee(distance: Int): Int {
            return if (distance < 3) 8 else 8 + (distance - 3) * 3
        }
    }

    //骑共享单车算法
    class BySharedBicycle : CalculateStrategy {
        override fun calculateTrafficFee(distance: Int): Int {
            return 2
        }
    }

    /**
       *第三步：使用算法
     */
    public class TrafficFeeCalculator{

        public fun gotoTianJinEye(strategy: CalculateStrategy, distance: Int): Int {
            return strategy.calculateTrafficFee(distance)
        }
    }
}