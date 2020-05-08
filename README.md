# RPC
手写简易版RPC框架
跟着讲师的代码一定会出bug。

有这么几个地方讲师代码遗漏

1.RpcClient中无参构造函数记得初始化this(new RpcClientConfig());

2.RandomTransportSelector#select 方法实现错误，是取不应该是删除；

3.Client测试类未传入实例化的RpcClientConfig()
还有些小问题估计是引入包时没注意，但总体老师讲的很精彩，花了3天消化这两小时，受益匪浅。

以下是运行成功的图：

Server端http://img4.sycdn.imooc.com/5eb51f6100017d6217890382.jpg

Client端：

http://img3.sycdn.imooc.com/5eb51f9d0001eaff12510145.jpg
