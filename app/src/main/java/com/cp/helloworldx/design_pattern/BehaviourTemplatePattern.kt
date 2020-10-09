package com.cp.helloworldx.design_pattern

import android.widget.TextView

/**
 * 模板方法
 * 在一个方法中定义一个算法的骨架，而将一些步骤的实现延迟到子类中，使得子类可以在不改变一个算法的结构前提下即可重定义该算法的某些特定步骤
 * 1.基类定义一套流程框架  2.子类继承实现 (比如现在BaseActivity receiveData initData intView)
 */
public class BehaviourTemplatePattern {

    /**
     * 场景: 切换直播平台
     */
    fun test(){

        TencentLivePlay().openRoom()

        JinShanLivePlay().openRoom()
    }

    public abstract class LivePlay {
        final fun seeLivePlay() {
            login();
            openRoom()
            startAudioAndVideoStream()
            pushVideoStream();
            stopAudioAndVideoStream();
            closeRoom()
        }

        open fun pushVideoStream() {}//钩子方法

        abstract fun stopAudioAndVideoStream()

        abstract fun closeRoom()

        abstract fun openRoom()

        abstract fun startAudioAndVideoStream()

        private fun login() {
            TODO("Not yet implemented")
        }
    }

    public class TencentLivePlay : LivePlay() {
        override fun stopAudioAndVideoStream() {
            TODO("Not yet implemented")
        }

        override fun closeRoom() {
            TODO("Not yet implemented")
        }

        override fun openRoom() {
            TODO("Not yet implemented")
        }

        override fun startAudioAndVideoStream() {
            TODO("Not yet implemented")
        }

    }


    public class JinShanLivePlay : LivePlay() {
        override fun stopAudioAndVideoStream() {
            TODO("Not yet implemented")
        }

        override fun closeRoom() {
            TODO("Not yet implemented")
        }

        override fun openRoom() {
            TODO("Not yet implemented")
        }

        override fun startAudioAndVideoStream() {
            TODO("Not yet implemented")
        }

    }
}