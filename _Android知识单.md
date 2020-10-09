项目内容


## 四大组件
### activity生命周期
1. onCreate->onStart->onResume->onPause->onStop->onDestory
2. 一个Activity开启另一额Activity时各生命周期函数调用顺序 A.onPause()-->B.onCreate()-->B.onStart()-->B.onResume()-->A.onStop()

### activity的几种launchmode及使用场景
- #### standard 模式
 这是默认模式，每次激活Activity时都会创建Activity实例，并放入任务栈中。使用场景：大多数Activity。
- #### singleTop 模式
如果在任务栈顶正好存在改Activity ，就重用该Activity( 会调用实例的 onNewIntent() ), 使用场景 如通知栏 点击重复进入Activity
- #### singleTask 模式
如果任务栈堆 有该Activity 就重用该实例，重用时 会让该实例回到栈顶 ，之前在它上面的实例会被移除  使用场景如 主界面  需要清空上面所有activity的情况
- #### singleInstance
单一实例模式， 整个手机操作系统只有一个实例 使用场景如: 呼叫来电


### 如何理解activity与view和window三者之间的关系 （非重点）
> Activity 是android 应用组件，提供一个屏幕 共用户交互 。每个activity会给于一个窗口 在上面可以绘制view
Activity作为Window和view之间的桥梁 将View显示在window上
1. Activity构造的时候会初始化一个Window，准确的说是PhoneWindow。
2. 这个PhoneWindow有一个“ViewRoot”，这个“ViewRoot”是一个View或者说ViewGroup，是最初始的根视图。
3. “ViewRoot”通过addView方法来一个个的添加View。比如TextView，Button等
4. 这些View的事件监听，是由WindowManagerService来接受消息，并且回调Activity函数。比如onClickListener，onKeyDown等。

Activity 层级关系：每个Activity包含一个PhoneWindow对象，PhoneWindow设置DecorView为应用窗口的根视图。在里面就是熟悉的TitleView和ContentView,没错，平时使用的setContentView()就是设置的ContentView

### fragment理解和生命周期 （非重点）
Fragment 作为碎片可以键入当前活动中UI
onAttach() ->onCreate->onCreateView->onActivityCreated->onStart->onResume->onPause->onStop->onDestoryView->onDetroy->onDetach

### stickyintent
粘性intent,  可以接受到注册前 发送的广播

### 启动service的两种方法和区别
startService 和 bindService， startService 启动后即与调用者没关系了 关闭需调用stopService, bindService与调用者绑定在一起可以进行通信 关闭了调用者服务也退出了

### intentService和service
IntenSerive 生成一个默认的与主线程相互独立的工作者线程来执行所有传送至onHandleIntent()方法的Intent。 同一时刻只传送一个Intent对象 不会出现多线程问题。 所以请求执行完后会自动停止服务。
提供onBind()方法实现 默认返回Null
- Serive 运行在后台但不能执行长时间的任务,IntentService 可以执行长时间任务
- 自动结束和不自动结束

### service是否在mainthread中执行service里面是否能执行耗时的操作
如果没有显示指明Service 进程，默认service和 activity运行在app说着的主线程里，不能执行耗时操作

### activity与intent和service是什么关系
Activity负责用户界面交互和显示 Service负责后台处理 Intent是四大组件的纽带


### service与activity通信的方式
- 通过Binder对象
- 通过广播


### onSaveInstance与onResotreInstance
#### 调用时机
一定是在 onStop() 方法之前调用, 但是不确定是在onPause() 方法之前还是之后调用
当activity容易被销毁的时候执行
1. 按Home建
2. 长按Home键 选择其他程序
3. 按下电源键
4. 从Activity切换到另外Activity
5. 屏幕切换



## View 相关
### view和viewgroup理解
Android 中所以UI类都是建立在View 和 ViewGroup中的，所有view的子类为widget 所有viewgroup子类为layout, Viewgroup作为布局容器最上层


### 如何自定义view
- 继承View
- 定义自定义属性
- 应用自定义属性
- 添加事件

### androidtouchevent事件分发机制
必须提到三个函数
#### dispatchTouchEvent()
用来分派事件。其中调用了onInterceptTouchEvent()和onTouchEvent()，一般不重写该方法
#### onInterceptTouchEvent()
用来拦截事件。ViewGroup类中的源码实现就是{return false;}表示不拦截该事件，事件将向下传递（传递给其子View）；若手动重写该方法，使其返回true则表示拦截，事件将终止向下传递，事件由当前ViewGroup类来处理，就是调用该类的onTouchEvent()方法
#### onTouchEvent（）
用来处理事件。返回true则表示该View能处理该事件，事件将终止向上传递（传递给其父View）；返回false表示不能处理，则把事件传递给其父View的onTouchEvent()方法来处理

[参考链接](http://blog.csdn.net/morgan_xww/article/details/9372285)



### androidview的绘制流程
整个View树的绘图流程是在ViewRoot.java类的performTraversals()函数展开的，可以经过三个过程 measure、layout、draw 过程
1. measure 为整个Vew树计算实际的大小，每个View控件实际的宽高都是由父视图和本视图决定
2. layout 根据子视图的大小和布局参数将View放到合适位置
3. draw 绘制

[参考链接](http://www.codekk.com/blogs/detail/54cfab086c4761e5001b253f)


### recyleview和listview 两者区别， 为啥listview 还在用
listView内部使用recycleBin 机制

### ConstraintLayout和RelativeLayout
对比

## 通信
### 序列化是什么如何实现的
将对象转换成字节流的过程，将该对象保存到内存中下次构建改对象时可以获取到之前的状态及数据信息。 两种方式 实现Serializable和 Parceable接口
- 使用内存时候 Parceable 性能高
- Serializable在序列化的时候会产生大量临时变量 从而引起频繁GC
- Parcelable 不能使用在数据存储在磁盘的情况建议使用Serialiable
- Protocol Buffer
### 为什么设计bundle而不是用hashmap
- Bundle内部是使用ArrayMap实现，ArrayMap内部实现是两个数组 一个int数组存储对象对于下标, 一个数组存储key和value ，内部使用二分法对key排序 在小数据量操作的时候 性能好并且比HashMap占用内存少
- Bundle 使用Parcelable序列化 HashMap使用Serializable序列化,推荐Parcelable 开销小

### handler的原理
- 使用场景 handler 一般用于延时操作或接收子线程发送的数据， 用此数据配合主线程更新UI。
- 原理: Looper负责创建MessageQueue 然后无限循环的从MessageQueue中读取 handler发过来的消息
[参考链接](http://blog.csdn.net/lmj623565791/article/details/38377229)



### binder机制原理
Binner 是Android进程间通信机制， 客户端和服务端进行通信的媒介
#### Binner系统架构
1. Service Manager 客户端通过ServiceManager来查询和获取所需要的服务
2. 服务(Service)
3. 客户端 一般指的是Android应用服务，比如Activity
4. 代理 客户端生成Server代理，调用服务端代码就跟调用本地一样
5. Binder驱动 位于内核层

[参考链接](https://blog.csdn.net/qq_23191031/article/details/60145022)

### aidl 实现步骤
全称是Android Interface Definition Language（Android 接口定义语言）， 用于在Android设备两个进程间通信，比如activity 调用另一个进程的 service 操作

步骤:
1. 创建aidl 文件并在其中定义接口如何aidl 内容正确会自动生成一个java文件
3. 建立一个服务类 实现你定义aidl文件生成的java接口
4. 在AndroidManifest.xml文件中配置AIDL服务
5. 客户端 通过bindService 绑定服务，调用服务方法


### android跨进程通讯的几种方式
1. 通过Intent访问其他应用程序Activity
2. Content Provider  访问系统相册
3. 广播
4. AIDL 服务

## 进程相关
### 有没有用过线程池  大概讲一下(重点)


### handlerthread和thread差别
hanlderThread 是 thread的子类， 它自带Looper 可以通过消息队列来重复使用当前线程， 每个任务都是逐个执行的， 如果某个任务执行时间长就会导致后续任务延迟处理


### android程序如何使用多进程
android 程序所有组件都在一个进程中执行的，改进程的名字就是程序的包名。同时android允许将一些组件在其他进程中执行。四大组件均支持androd:process属性， 可以设置该属性的名字 将组件运行在指定的进程
- 为什么使用多进程
1. 更大的内存分配
2. 防止进程被杀死
3. 分担主进程的内存压力
- 有什么问题
1. 静态成语和单例完全失效
2. 线程同步机制失效
3. SharePreferences 可靠性下降
4. Application 多次创建，不能保持数据到Application 中

### android进程管理
每个App 都有自己的进程，每个进程都有自己的内存空间， 当App出现问题后只杀死当前进程，不会导致其他app受牵连
#### 前台进程
正在与用户交互的进程
#### 可见进程
可以看到 但不可交互，如被dialog遮挡
#### 服务进程
运行在后台 如Service
#### 后台进程
比如按Home 返回到界面，这个app就切换回后台进程了
### 空进程
这些进程内部没有东西运行 保留进程目的是为了下次更快启动



### asyncTask相关
##### AsynTask内部实行 使用场景
内部是通过Handler 机制来完成，Android提供执行框架来提供线程池执行相关任务，因为线程池的大小问题 只能执行耗时短的任务如http请求对于大规模下载不适用AysncTask会造成线程池堵塞 发现AysncTask执行不了
##### 1.AsynTask为什么要设计为只能够一次任务？
 最核心的还是线程安全问题，多个子线程同时运行，会产生状态不一致的问题。所以要务必保证只能够执行一次

 ##### 2.AsynTask造成的内存泄露的问题怎么解决
 比如非静态内部类AsynTask会隐式地持有外部类的引用，如果其生命周期大于外部activity的生命周期，就会出现内存泄漏注意要复写AsynTask的onCancel方法，把里面的socket，file等，该关掉的要及时关掉在 Activity 的onDestory()方法中调用Asyntask.cancal方法Asyntask内部使用弱引用的方式来持有Activity

 ##### 3. 若Activity已经销毁，此时AsynTask执行完并且返回结果，会报异常吗?
 当一个App旋转时，整个Activity会被销毁和重建。当Activity重启时，AsyncTask中对该Activity的引用是无效的，因此onPostExecute()就不会起作用，若AsynTask正在执行，折会报 view not attached to window manager 异常同样也是生命周期的问题，在 Activity 的onDestory()方法中调用Asyntask.cancal方法，让二者的生命周期同步

 ##### 4. Activity销毁但Task如果没有销毁掉，当Activity重启时这个AsyncTask该如何解决？
还是屏幕旋转这个例子，在重建Activity的时候，会回掉Activity.onRetainNonConfigurationInstance()重新传递一个新的对象给AsyncTask，完成引用的更新


## 其他


### jni调用
JNI 全称是Java Native Interface(Java 本地接口)是一层接口，用来沟通java代码和C/C++ 之间的。 使两者可以互相调用、
Java 优点是跨平台 和 操作系统之间通过JVM完成，但一些和操作系统相关的操作无法完成
加载SO库

### android推送原理
长连接 + 心跳


## android优化

### anr
应用程序在一段时间不够灵敏，系统就会显示一个对话框  可以通过查看/data/anr/trace.txt
##### 产生的原因:
1. 来自AMS的回调消息 当AMS对应用组件的生命周期进行回调的时间超过自定义的响应时间就会包ANR，回调函数及超过时间如下:
```
Activity: onCreate(), onResume(), onDestroy(), 
onKeyDown(), onClick()等，超时时间5s

Application: onCreate(), onTerminate()等，超时时间5s

Service: onCreate(), onStart(), onDestroy()等，超时时间20s

BroadcastReceiver：onReceiver()，前台APP广播超时时间是10s，后台App是60s
```
2. App 其他操作运行在UI线程的

```
AsyncTask: onPreExecute(), onProgressUpdate(), onPostExecute(), onCancel()等，超时5s

Mainthread handler: handleMessage(), post*(runnable r)等，超时5s
```
##### 如何避免
1. 耗时操作放入子线程中
2. 使用handler 来处理UI 线程和其他线程的交互

[参考链接](http://www.jianshu.com/p/124f3b75e164)


### android内存泄漏
当一个对象已经不需要使用了，本该回收的时候，另一个正在使用的对象持有它的引用导致它不能被回收 这不能回收的对象就在推内存中，就产生了内存泄漏  当内存超出系统分配的内存限额 引用就会Crash

- 常见内存泄漏汇总
1. 单例造成的内存泄漏
2. 非静态内部类 创建静态实例造成的内存泄漏
3. Handler造成的内存泄漏
4. 线程造成的泄漏
5. 资源未关闭造成的内存泄漏
6. 大图片 Bitmap对象占有内存 bitmap用完用bitmap.recycle()
7. 明确的调用System.gc()
[参考链接](https://juejin.im/entry/56d64b9e816dfa005943a55c)



### 布局优化
1.合理选择控件容器， 尽量减少层次 相同层次使用LinearLayout
2. 去掉window的默认背景
3. 去掉其他不别要的背景
4. 使用标签<include> <merge><ViewStub> ViewStub 高效占位符， 对于比较复杂的需要显示隐藏的布局 可以通过viewStub 控制
5. 使用TextView的leftDrawabel/rightDrawable代替ImageView+TextView布局
6. .使用ListView时需要复用contentView，并使用Holder减少findViewById加载View。
7. 自定义View时，重写onDraw()方法，不要在该方法中新建对象，否则容易触发GC，导致性能下降


### 内存优化

1. 避免创建不必要的对象
2. 静态
3. 避免内部getter/setters
4. 将成语变量缓存到本地
5. 对常量使用 final static
6. 减少不必要的全局变量 static
7. 不要过多指望GC 不用的对象指向null 显示让系统gc回收如图片 bitmap.recycle
8. 缓存
9. 关闭资源对象 cursor.close, inputstream.close
a.Bitmap.recycle(),Cursor.close,inputStream.close()

b.大量加载Bitmap时，根据View大小加载Bitmap，合理选择inSampleSize，RGB_565编码方式；使用LruCache缓存

c.使用 静态内部类+WeakReference 代替内部类，如Handler、线程、AsyncTask

d.使用线程池管理线程，避免线程的新建

e.使用单例持有Context，需要记得释放，或者使用全局上下文

f.静态集合对象注意释放

g.属性动画造成内存泄露

h.使用webView，在Activity.onDestory需要移除和销毁，webView.removeAllViews()和webView.destory()

备：使用LeakCanary检测内存泄露




### 图片优化
一些优化方案  非重点
[参考链接](http://www.jianshu.com/p/5bb8c01e2bc7)

### 电量优化
- 减少网络请求: 对数据做缓存
- 尽量避免wake lock
- 小心使用AlarmManager
- 对移动网络和wifi 应用不同的逻辑
- 小心使用GPS
- 检查 后台程序
- 批处理网络调用
- 使用 JobScheduler
### 图片缓存
内存缓存 LruCache + 磁盘缓存 DiskLruCache + 网络请求 组成三级缓存


### android系统架构
Android 系统架构大致分为四层架构 五块区域:
1. Linux 内核  
Android 系统建立在Linux 2.6之上，Linux 内核提供了 安全性，内存管理，进程管理，网络协议栈和驱动模型等核心服务。 也是系统硬件和软件叠层的抽象。 本质包含线程调度 内存管理及输入/输出管理。 为Android 设备的各种硬件提供了底层的驱动，如显卡驱动 音频驱动 照相机驱动 蓝牙驱动 等

2.系统运行库层  libraries 层

通过一些C/C++ 库来为Android 系统提供了 主要的特性支持，如SQLite库 提供了数据库的支持,OpenGL | ES库提供了3D绘图的支持，WebKit 提供了浏览器内核的支持。

Android 运行时 Android 运行时 由两部分组成: Android 核心库集成和Dalvik， 其中核心库提供了java语言核心库所能使用的 大部分功能。 而Dalvik 负责运行Android 应用程序。 Dalvik 运行的是.dex文件格式的。 其实由 DX工具将应用的所有.class 编译成一个 .dex文件。
同样在这一层有Android 运行时库, 它主要提供了一些核心库，用来支持开发者使用Java来编写代码。还包含Dalvik 虚拟机, 使每个Android应用都能运行在独立的进程中, 并且拥有一个自己的Dalvik 虚拟机实例。

3. 应用框架层  framework 层

提供构建应用可能所需的各种Api.

4. 应用层  application层 就是安装手机上的程序


### dalvik和jvm差别与art比较
https://blog.csdn.net/qq_27073205/article/details/46240261
1.Dalvik 基于寄存器,JVM 基于栈
2.jvm运行的是字节码文件，而dvm运行自己定义的dex文件格式
JVM编译过程 java->class->jar
DVM编译过程java->class->dex


3.Dalvik设计规则
3.1每一个app都运行在自己的DVM实例中与应用隔离。
3.2启动一个app进程，一个DVM也就诞生了,该app下的代码在DVM实例下解释运行
3.3有几个app进程就有几个dvm实例。
3.4dvm对对象生命周期(组件生命周期理解)、堆栈、线程、异常以及垃圾回收进行管理。
3.5不支持j2se和j2me的api，也就不支持awt和swing(现在用的也非常少)

4.和ART的比较
在dalvik中，app每一次运行都要通过即时编译器转化成机器码，这要多了一个编译过程，会降低运行速度。
而ART则是在安装时，直接将字节码编译成本机机器码，实现了真正的本地应用，在以后的运行中不需要每次都翻译。这样速度更快，但是所占用的存储空间越大。(5.0新特性)



#### Android版本区别4.0 - 8.0
这里主要回答 api 的区别

https://juejin.im/post/6844903906942648334

### supportlibrary是什么为什么要引用
suppport library是很多包的集合 包里有很多类

Android App开发的本质是对Android系统提供的api进行运用，具体就是运用SDK, 不过不同的系统版本提供的SDK是有差别的，   希望它尽可能的在不同版本系统里运行 让老版本可以拥有新系统的一些特性

---

## 进阶

### android如何捕获未处理的异常
自 定 义 一 个 Application ， 比 如 叫 MyApplication 继 承 Application 实 现UncaughtExceptionHandler。覆写 UncaughtExceptionHandler 的 onCreate 和 uncaughtException 方法。

### 热修复技术
http://www.bbs0101.com/archives/1437.html
1. QQ空间补丁  使用多dex加载的原理，将要修复的方法放到一个单独Dex中然后插入到dexElements数组最前面。
2. Tinker   生成差异包 ，下载到本地 合并差异包， 替换整个dex
3. HotFix  将方法指针指向新方法


### 插件化技术
1. 360 插件话 RePlugin
2. 弟弟的 VirtualApk
3. 阿里的  atlas

这里要说一下双亲加载机制,DexClassLoader PathClassLoader  AssetClassLoader


### app设计架构
MVC MVP MVVM

MVC : View 传递指令--> Controller 完成业务逻辑，要求Model改变状态--> Model  将新数据发送给--> View

MVP: View --> Presenter < ---- >

MVVM: DataBinding
[参考链接](https://www.tianmaying.com/tutorial/AndroidMVC)

[参考链接](https://juejin.im/entry/56ebb4ad5bbb50004c440972)


### google刚出的几种开源库
1. ViewModel
2. lifecycles  管理生命周期的
3. Data Binding
4. LiveData
5. Room

### 常用第三方库
1. OKHttp 源码理解
2. Refrofit  常用操作符, 动态加载机制
3. 图片加载库 glide picasso fresco 区别，怎么选型


### rxjava
RXJava 常用的操作符

#### 用线程池线程数量 经验值是这样
程池的大小经验值应该这样设置：（其中N为CPU的核数）如果是CPU密集型应用，则线程池大小设置为N+1
如果是IO密集型应用，则线程池大小设置为2N+1


https://github.com/leavesC/ReactiveHttp
Android持续集成：Jenkins+Github+蒲公英/Fir.im+邮件通知: https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488151&idx=1&sn=f329687505b416cd898c843ca558b693