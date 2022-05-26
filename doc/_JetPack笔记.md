- [官方文档链接]( https://developer.android.google.cn/jetpack/getting-started)

1. 创建新协程或者调用 witchContext ， 不要直接指定 IO线程, 从外部传进来（这种依赖项注入模式可以降低测试难度）
```
class NewsRepository(private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default) {
    suspend fun loadNews() = withContext(defaultDispatcher) { /* ... */ }
}

```
