package com.cp.helloworldx.design_pattern

/**
 * 行为型模式-- 状态模式——优化登录操作
 * 此模式最关键的地方在于不同状态下对同一行为有不同的实现,适用的情况应该是用于有限状态机的设计上
 * 1. 定义接口
 * 2.不同实现类去实现这个接口
 * 3.定义以接口为类型的变量
 * 4. 定义操作类， 包含变量:以接口函数为类型    函数: 1. 赋值变量 到底是哪个实现类  2.接口的操作方法
 *
 */
public class BehaviourStatePattern {


    fun main(){
        LoginContext.login()
        LoginContext.pay()
        LoginContext.editMessage()

        LoginContext.loginOut()
        LoginContext.pay()
    }



   object  LoginContext {
        var mUserState: UserState = LoginOutState()

        fun login() {
            mUserState = LoginState()
        }

        fun loginOut() {
            mUserState = LoginOutState()
        }

        fun pay(){
            mUserState.pay()
        }

        fun editMessage(){
            mUserState.editMessage()
        }

        fun share(){
            mUserState.share()
        }

    }

    public interface UserState {
        fun pay()
        fun editMessage()
        fun share()
    }

    class LoginState : UserState {
        override fun pay() {
            print("支付")
        }

        override fun editMessage() {
            print("编辑")
        }

        override fun share() {
            print("分享")
        }

    }

    class LoginOutState : UserState {
        override fun pay() {
            print("去登陆")
        }

        override fun editMessage() {
            print("去登陆")
        }

        override fun share() {
            print("去登陆")
        }

    }
}