package com.cp.helloworldx.design_pattern

/**
 * 责任链模式
 * 说明: 将多个对象通过引用连接起来形成一条链。请求在这个链上传递，直到链上的某一个对象决定处理此请求。
 * 场景: 解耦请求的发送者和接受者
 * 对于客户来说并不知道请求在哪一个环节被处理了。从而实现了请求和处理之间的解耦合。
 */
public class BehaviorChainOfResponsibilityPattern {


    public fun test() {
        getChainOfLoggers().logMessage(AbstractLogger.ERROR, "ssssdd")
        getChainOfLoggers().logMessage(AbstractLogger.INFO, "ssssdd")
    }

    /**
     * 步骤 1
    创建抽象的记录器类。
     */
    public abstract class AbstractLogger(var level: Int) {
        companion object {
            val INFO = 1
            val DEBUG = 2
            val ERROR = 3
        }


        public var nextLogger: AbstractLogger? = null


        public fun logMessage(level: Int, message: String) {
            if (this.level <= level) {
                write(message)
            }

            nextLogger?.logMessage(level, message)
        }

        abstract protected fun write(message: String)
    }

    /**
     * 步骤 2
    创建扩展了该记录器类的实体类。
     */
    public class ConSoleLogger(level: Int) : AbstractLogger(level) {
        override fun write(message: String) {
            print("ConSole logger$message")
        }
    }

    public class ErrorLogger(level: Int) : AbstractLogger(level) {
        override fun write(message: String) {
            print("error logger$message")
        }
    }


    public class FileLogger(level: Int) : AbstractLogger(level) {
        override fun write(message: String) {
            print("file logger$message")
        }
    }

    /**
     * 第三部 创建不同类型的记录器。赋予它们不同的错误级别，并在每个记录器中设置下一个记录器。每个记录器中的下一个记录器代表的是链的一部分。
     */
    companion object {
        fun getChainOfLoggers(): AbstractLogger {
            var errorLogger = ErrorLogger(AbstractLogger.ERROR);
            var fileLogger = ErrorLogger(AbstractLogger.DEBUG);
            var consoleLogger = ErrorLogger(AbstractLogger.INFO);

            errorLogger.nextLogger = fileLogger
            fileLogger.nextLogger = consoleLogger
            return errorLogger
        }

    }
}