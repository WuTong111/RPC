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

## 项目架构分析

**1.common通用工具模块**

**2.serialize序列化模块**

> ​	序列化和反序列化实现，利用fastjson.JSON实现

**3.transport网络传输模块**

- ```java
  //处理网络请求的handle
  public interface RequestHandler {
      void onRequest(InputStream recive, OutputStream toRespon);
  }
  ```

- ```java
  //RPC server服务定义
  public interface TransportServer {
      //初始化Server服务
      void init(int port, RequestHandler handler);
      //开启Server服务
      void start();
      //关闭Server服务
      void stop();
  }
  ```

- ```java
  //客户端 也是服务消费者
  public interface TransportClient {
      //连接Server服务
      void connect(Peer peer);
      //订阅Server服务  并返回response
      InputStream write(InputStream data);
      //关闭
      void close();
  }
  ```

**4.Server模块**

> ​	主要调用网络传输模块中`HttpTransportServer`，将请求在Handle中实现，并封装在Response中。
>
> ​	服务注册，服务管理，服务发现的实现

**5.Client模块**

> ​	选择一个server端点连接，然后代理反射调用方法。
