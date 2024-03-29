4. 你同意 组合优先于继承 吗 ？
继承的功能非常强大，但是也存在诸多问题，因为它违背了封装原则 。 只
有当子类和超类之间确实存在子类型关系时，使用继承才是恰当的 。 即使如此，如果子
类和超类处在不同的包中，并且超类并不是为了继承而设计的，那么继承将会导致脆弱性
( fragility ） 。 为了避免这种脆弱性，可以用复合和转发机制来代替继承，尤其是当存在适当
的接口可以实现包装类的时候 。 包装类不仅比子类更加健壮，而且功能也更加强大。（也就是装饰者模式）。
具体见 Effective Java 18条 复合优先于

集合和泛型
11. Arrays vs ArrayLists
Arrays 是一个工具类，提供了许多操作，排序，查找数组的静态方法。
ArrayList 是一个动态数组队列，实现了 Collection 和 List 接口，提供了数据的增加，删除，获取等方法。
12. HashSet vs TreeSet
HashSet 与 TreeSet 都是基于 Set 接口的实现类。其中 TreeSet 是 Set 的子接口 SortedSet 的实现类。
HashSet 基于哈希表实现，它不保证集合的迭代顺序，特别是它不保证该顺序恒久不变。允许 null 值。不支持同步。
TreeSet 基于二叉树实现，它的元素自动排序，按照自然顺序或者提供的比较器进行排序，所以 TreeSet 中元素要实现 Comparable 接口。不允许 null 值。


30. 关键字 synchronized 的作用 ？
关键字 synchronized 可以修饰方法或者以同步块的形式来进行使用，它主要确保多个线程在同一时刻，只能有一个线程处于方法或同步块中，它保证了线程对变量访问的可见性和排他性。

对于普通同步方法，锁是当前实例对象
对于静态同步方法，锁是当前类的 Class 对象
对于同步方法块，锁是 Synchonized 括号里配置的对象

31. ThreadPoolExecutor 作用 ？
在 Java 中，使用线程来执行异步任务。Java 线程的创建与销毁需要一定的开销，如果我们为每一个任务都创建一个新线程来执行，这些线程的创建与销毁将消耗大量的计算资源。同时，为每一个任务创建一个新线程来执行，这种策略可能会使处于高负荷的应用最终崩溃。
关于线程池的详细介绍，推荐一篇文章 Java并发编程：线程池的使用
32. 关键字 volatile 的作用 ？
volatile 是轻量级的 synchronized，它在多处理器开发中保证了共享变量的 可见性。volatile 用来修饰字段(成员变量),就是告知程序任何对该变量的访问均需从共享内存中获取，而对它的改变必须同步刷新回共享内存，它能保证所有线程对变量访问的可见性。
但是，过多的使用 volatile 是不必要的，因为它会降低程序执行的效率。



### 封装继承多态抽象理解
封装: 把过程和数据包围起来
继承: 把提出共同点作为父类，子类继承后重写自己的特点
抽象: 把事务归类便于管理,把相同点提出来。
多态: 由继承而产生的相关的不同的类，其对象对同一消息会做出不同的响应
### 多态的意义
- 定义: 允许不同类的对象对同一消息做出相应。即同一消息可以根据发送对象的不同而采取- 多重不同的行为方式。(发送消息就是函数调用)
- 多态的作用: 消除类型中的耦合关系
- 多态的好处: 可替换性 可扩充性 接口性 灵活性
- 实现方式: 接口实现 继承父类方法进行重写 同一类中进行方法重载

### 泛型的意义
定义: 参数化类型,
使用的场景: 当你希望代码能够跨多个类型 工作的时候
比如有一删除确认框 需要在很多地方用到 但删除对象模型不一样
```
public static <T> void showMessageDialog(Context context, String message, final T t, final OnBtnClickListener<T> callback) {
        ...
        submitBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onOkClick(t); // 点击确认按钮，将对象回调
                }
                dialog.dismiss();
            }
        });
        cancelBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onCancelClick(t); // 点击取消按钮，将对象回调

                }
                dialog.dismiss();
            }
        });
}

接口定义
public interface OnBtnClickListener<T> {
    void onOkClick(final T t);
    void onCancelClick(final T t);
}
```

### 接口interface和抽象类abstract的意义

抽象类 对一种事物的抽象，即对整个类整体抽象包括属性 行为，可以作为摸版式设计
接口 只对 局部行为进行抽象作为一种 行为规范

语法上区别:
- 抽象类可以提供具体实现，接口只能提供public abstract方法
- 抽象类 成员可以是各种类型 ，接口成语只能是public static final 类型(默认就是这个)
- 一个类只能继承一个抽象类 确可以实现对个接口(另一角度实现多继承)

[参考链接](http://blog.csdn.net/nvd11/article/details/41129935)






### volatile和synchronized不同
volatile 是变量修饰符 线程每次使用变量时都会读取变量修改后的最新值
synchronized 修饰方法 同一时刻只能有一个线程能够使用

### enqual和==和hashCode
equal 对比的对象值,==对比的是对象的内存空间地址, hashCode 返回改对象的哈希码值
- 为什么要覆盖hashCode方法？

我们知道，把对象存入HashMap或HashSet中当key的时候，会调用对象的hashCode方法得到一个值，运用这个值使用哈希算法进行运算，定位到具体的某个位置或者某个区域中，这里说区域，是因为hashCode不能保证是唯一的，有可能不同对象生成的hashCode会相同，这时，就会遍历这些区域的对象，并调用其equals进行比较，才能确定这个对象是唯一的。
因此，hashCode和equals自然而然的成为青梅竹马，天生一对，但是青梅竹马也不一定最终在一起的！如果你的对象由此至终都不考虑存入这种HashMap或HashSet当key，或者不涉及哈希操作，完全可以不考虑覆盖hashCode

- 如果两个对象x和y满足x.equals(y) == true，它们的哈希码（hash code）应当相同。
 Java对于eqauls方法和hashCode方法是这样规定的：(1)如果两个对象相同（equals方法返回true），那么它们的hashCode值一定要相同；(2)如果两个对象的hashCode相同，它们并不一定相同。

### static意义
方便在没有创建对象的情况下进行调用 方法/变量
- 静态方法: 不依赖外部对象可以直接访问
- 静态变量: 静态变量被所以对象所共享在内存中只有一个副本，只有在类初次加载时会被初始化
- 静态代码块: 在类初次加载时 按照static块顺序执行

### string和stringBuffer与stringbuilder的区别
String 是不可变的对象 ,StringBuffer和 StringBuilder底层是char[]数组实现的，StringBuffer是线程安全 StringBuilder是线程不安全



### 进程和线程的区别
进程是系统进行资源分配和调度的一个独立单位。 线程是进程的一个实体 是CPU调度和分派的基本单位 是比线程更小的能独立运行的基本单位
* 一个程序至少有一个进程 比如Android每个应用都在自己进程中运行，一个进程可以至少有一个线程

* 进程拥有独立的内存单元 所以不同进程的是不能直接通信需要IPC。 同一进程的多个线程共享数据空间
* 线程上下午切换比进程切换快的多

### thread中sleep和wait区别
- sleep 让出CPU资源 以留一定时间给其他线程执行 不会释放对象锁 需要指定一个睡眠时间后不会立刻执行而是等调度队列
- wait 会释放对象锁 使用notify或者notifyAlll或者指定睡眠时间来唤醒当前等待池中的线程。

[链接](https://blog.csdn.net/a19881029/article/details/39028461)

### java反射原理
定义: 动态加载对象，对于任意对象都能够调用他的任意一个方法，这种动态获取的信息以及动态调用对象的方法的功能称为Java语言的反射机制。

[参考链接](http://www.jianshu.com/p/3968ffabdf9d)

### java注解

### 强引用-软引用-弱引用-虚引用
- 强引用: 不会被回收 即使当前内存不足
- 软引用SoftReference: 内存足够继续使用，当内存不足时会回收 比如图片加载框架
- 弱引用WeakReference: JVM(Java 虚拟机)进行垃圾回收时 无论内存是否充足就会被回收
比如Handler持有Activity
- 虚拟用:

对象经常使用就使用软引用，如果不被使用的可能性更大 就是用弱引用

### java回收机制
JAVA 通过GC 确认对象是否被其他引用 确定是否收集该对象
##### 触发的条件（时间）
1.GC在优先级最低的线程中运行 所以在应用程序空闲的时候被调用
2.当JAVA堆内存不足的时候
##### 对谁回收
把内存分为几块，年轻化 老年块 永久， 如果对象经过几轮都没被回收就进入老年块 采用不同的算法回收

##### 减少gc开销的措施
1. 减少临时对象的使用
2. 对象不用的时候设置为null
3. 对于操作string 尽量用stringbuffer
4. 少用静态对象变量
5. 能用基本内形用基本内形


### jave虚拟机特性
java语言一个重要特点就是与平台无关性，引用java虚拟机后java在不同平台运行时不需要重新编译

## 网络
### http协议
##### 是什么
客户端与服务端之间数据传输的格式规范
#### 有什么组成
请求报文包含三部分
1. 请求行:  包含请求方法(GET/POST) URL HTTP版本信息
2. 请求首部抱头 包含Host(请求资源所在服务器) Acc
3. 请求内容实体:

响应报文包含三部分
1. 响应行: 包含Http版本 状态码 状态码原因标语
2. 响应首部字段
3. 响应内容实体
### 有哪些请求方式
1. Get
2. Post
3. put
4. Head
5. delete
6. options


### httpurlconnection与httpclient区别
HttpClient是Apache Jakarta Common下的子项目


    HttpURLConnection是一种多用途、轻量极的HTTP客户端
    
    在 JDK 的 java.net 包中已经提供了访问 HTTP 协议的基本功能：HttpURLConnection。HttpURLConnection继承自URLConnection.

HttpURLconnection默认带GZIP压缩。


在Android 2.2版本之前，HttpClient拥有较少的bug，因此使用它是最好的选择。

而在Android 2.3版本及以后，HttpURLConnection则是最佳的选择。它的API简单，体积较小，因而非常适用于Android项目。压缩和缓存机制可以有效地减少网络访问的流量，在提升速度和省电方面也起到了较大的作用。


### socket建立网络连接的步骤
 建立Socket连接至少需要一对套接字，其中一个运行于客户端，称为ClientSocket ，另一个运行于服务器端，称为ServerSocket 。

　　套接字之间的连接过程分为三个步骤：服务器监听，客户端请求，连接确认。

1. 服务器监听：服务器端套接字并不定位具体的客户端套接字，而是处于等待连接的状态，实时监控网络状态，等待客户端的连接请求。

2. 客户端请求：指客户端的套接字提出连接请求，要连接的目标是服务器端的套接字。

　　为此，客户端的套接字必须首先描述它要连接的服务器的套接字，指出服务器端套接字的地址和端口号，然后就向服务器端套接字提出连接请求。

3. 连接确认：当服务器端套接字监听到或者说接收到客户端套接字的连接请求时，就响应客户端套接字的请求，建立一个新的线程，把服务器端套接字的描述发给客户端，一旦客户端确认了此描述，双方就正式建立连接。

　　而服务器端套接字继续处于监听状态，继续接收其他客户端套接字的连接请求
　　
### tcp与udp
- TCP: 传输控制协议
- UDP: 用户数据报协议
#### 区别
1. 基于连接与无连接；
2. 对系统资源的要求（TCP较多，UDP少）；
3. UDP程序结构较简单；
4. 流模式与数据报模式 ；
5. TCP保证数据正确性，UDP可能丢包，TCP保证数据顺序，UDP不保证。

### tcp三次握手
1 主机A通过向主机B 发送一个含有同步序列号的标志位的数据段给主机B ,向主机B 请求建立连接,通过这个数据段,
主机A告诉主机B 两件事:我想要和你通信;你可以用哪个序列号作为起始数据段来回应我.
2 主机B 收到主机A的请求后,用一个带有确认应答(ACK)和同步序列号(SYN)标志位的数据段响应主机A,也告诉主机A两件事:
我已经收到你的请求了,你可以传输数据了;你要用哪佧序列号作为起始数据段来回应我
3 主机A收到这个数据段后,再发送一个确认应答,确认已收到主机B 的数据段:"我已收到回复,我现在要开始传输实际数据了
这样3次握手就完成了,主机A和主机B 就可以传输数据了.
3次握手的特点
没有应用层的数据
SYN这个标志位只有在TCP建产连接时才会被置1
握手完成后SYN标志位被置0



### 四次挥手

### https 加密流程
https: 两次http请求
1. C请求Server
2. S-> 公钥-> C
3. C->加密传输内容->S
4. S用自己私钥 解密
HTTPS通信流程
一个HTTPS请求实际上包含了两次HTTP传输，可以细分为8步。

第一次HTTP请求:
1.客户端向服务器发起HTTPS请求，连接到服务器的443端口。
2.服务器端有一个密钥对，即公钥和私钥，是用来进行非对称加密使用的，服务器端保存着私钥，不能将其泄露，公钥可以发送给任何人。
3.服务器将自己的公钥发送给客户端。
4.客户端收到服务器端的公钥之后，会对公钥进行检查，验证其合法性，如果公钥合格，那么客户端会生成一个随机值，这个随机值就是用于进行对称加密的密钥，我们将该密钥称之为client key，即客户端密钥，这样在概念上和服务器端的密钥容易进行区分。然后用服务器的公钥对客户端密钥进行非对称加密，这样客户端密钥就变成密文了，至此，HTTPS中的第一次HTTP请求结束。

第二次HTTP请求:
1.客户端会发起HTTPS中的第二个HTTP请求，将加密之后的客户端密钥发送给服务器。
2.服务器接收到客户端发来的密文之后，会用自己的私钥对其进行非对称解密，解密之后的明文就是客户端密钥，然后用客户端密钥对数据进行对称加密，这样数据就变成了密文。
然后服务器将加密后的密文发送给客户端。
3.客户端收到服务器发送来的密文，用客户端密钥对其进行对称解密，得到服务器发送的数据。这样HTTPS中的第二个HTTP请求结束，整个HTTPS传输完成。'

#### http1.1版本支持长连接
即请求头添加Connection: Keep-Alive，使用Keep-Alive模式(又称持久连接，连接复用

####  HTTP 和 HTTPS 的区别
HTTP是明文传输，不安全的，HTTPS是加密传输，安全的多
HTTP标准端口是80，HTTPS标准端口是443
HTTP不用认证证书免费，HTTPS需要认证证书要钱
连接方式不同，HTTP三次握手，HTTPS中TLS1.2版本7次，TLS1.3版本6次
HTTP在OSI网络模型中是在应用层，而HTTPS的TLS是在传输层
HTTP是无状态的，HTTPS是有状态的


### 异常
异常类型、正确处理异常、自定义异常

Error 和 Exception

异常链、try-with-resources

finally 和 return 的执行顺序



封装、继承、多态

！1、Java中实现多态的机制是什么，动态多态和静态多态的区别
！2、接口和抽象类的区别，如何选择

！3、Java能不能多继承，可不可以多实现


%4、Static Nested Class 和 Inner Class的不同


！5、重载和重写的区别。
！6、是否可以继承String类
！7、构造器是否可被override?
！8、public,protected,private的区别?

集合相关

异常相关

！1、Error和Exception的区别
！2、异常的类型，什么是运行时异常
！3、final、finally和finalize的区别
%4、try-catch-finally中，如果在catch中return了，finally中的代码还会执行么，原理是什么？
！5、列举3个以上的RuntimeException
！6、Java中的异常处理机制的简单原理和应用

其它

！1、String和StringBuffer、StringBuilder的区别
！2、==和equals的区别
%3、hashCode的作用，和equals方法的关系
！4、Input/OutputStream和Reader/Writer有什么区别
！5、如何在字符流和字节流之间转换？
！6、switch可以使用那些数据类型
%7、Java的四种引用
！8、序列化与反序列化
！9、正则表达式
！10、int和Integer的区别，什么是自动装箱和自动拆箱

Java高级
多线程

！1、进程和线程的区别
！2、并行和并发的区别和联系
！3、同步与异步
！4、多线程的实现方式，有什么区别
！5、什么叫守护线程
%6、如何停止一个线程？
！7、什么是线程安全？
！8、synchronized 和 lock的区别
！9、当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法?
！10、启动一个线程是用run()还是start()?
！12、wait和sleep的区别
%13、notify和notifyAll的区别
%14、线程池的作用
%15、Java中线程池相关的类

JVM底层技术

！1、gc的概念，如果A和B对象循环引用，是否可以被GC？
%2、jvm gc如何判断对象是否需要回收，有哪几种方式？
！3、Java中能不能主动触发GC
！4、JVM的内存结构，堆和栈的区别
！5、JVM堆的分代
%6、Java中的内存溢出是什么，和内存泄露有什么关系
！7、Java的类加载机制，什么是双亲委派
！8、ClassLoader的类加载方式

IO

！ 1、NIO、AIO和BIO 之间的区别
？2、IO和NIO常用用法

其它

？1、hashcode 有哪些算法
！2、反射的基本概念，反射是否可以调用私有方法
！3、Java中范型的概念
？4、JVM启动参数，-Xms和 -Xmx
%5、代理机制的实现
！6、String s = new String("s")，创建了几个对象。


常见的八大排序方式

时间复杂度的计算

链表相关算法，链表翻转，链表合并等

二叉树相关算法前序、中序、后序遍历（递归，迭代）

​红黑树与BL树