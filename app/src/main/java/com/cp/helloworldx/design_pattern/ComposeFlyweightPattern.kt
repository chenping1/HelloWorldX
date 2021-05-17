package com.cp.helloworldx.design_pattern

/**
 * 享元模式
 * 为了解决大梁创建相同对象 造成OOM
 * 缓存数据 如果是相同则返回 不同则创建实例
 */
class ComposeFlyweightPattern {

    public fun test(){
         HttpFactory().getRequestList("baidu");
        //...
         HttpFactory().getRequestList("baidu");
    }
    public class Request{

    }

    public class HttpFactory{
        companion object{
            var requestMap = mutableMapOf<String,Request>()
        }

        public fun getRequestList(name : String) : Request{
            var request = requestMap.get(name)
            if(request == null){
                request = Request()
                requestMap[name] = request
            }
            return request
        }
    }

}