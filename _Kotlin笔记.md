kotlin KTX(简化kotlin 操作)  -- > Kotlin 协程

1. Java类中引用Kotlin类，找不到符号
在模块的build.gradle文件头部中加入
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'

