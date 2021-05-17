package com.cp.helloworldx.design_pattern

/**
 *  观察者模式
 *  说明: 多个观察者监听同一主题对象， 当主体对象状态更新会通知所有观察者 使他能够自动更新自己
 *  使用list 存储  观察者接口， 需要再通知
 */
public class BehaviorObserverPattern {

    public fun test() {
        var listener = object : IWeather {
            override fun notifyRain() {
                print("响应时间")
            }
        }


        WeatherObservable.register(listener)


        WeatherObservable.notifyRain()
    }

    public interface IWeather {
        fun notifyRain()
    }

    object WeatherObservable : IWeather {

        var list: MutableList<IWeather> = mutableListOf()

        public fun register(listener: IWeather) {
            list.add(listener)
        }

        public fun unRegister(listener: IWeather) {
            if (list.contains(listener)) {
                list.remove(listener)
            }
        }


        override fun notifyRain() {
            for (listener in list) {
                listener.notifyRain()
            }
        }


    }


}