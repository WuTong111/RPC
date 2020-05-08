**RPC含义**:远程过程直接调用。

**远程调用方式**：RESTful、WebService、HTTP、RPC、基于DB的远程数据调用等

**在RPC中运用的设计模式**：采用消费者模式

​	Server:Provider      Client:Consumer

​	Stub:存根、服务描述

![image-20200429164542522](/images/image-20200429164542522.png)



**需要掌握的技术：**

> Maven、反射、Java的动态代理、序列化(Java对象于二进制数据互转)：fastjson、网络通信：jetty、URLConnection



总结：
![image-20200508152650728](/images/image-20200508152650728.png)

协议制定的类：Request、Response

**实现顺序**

![image-20200508163233305](/images/image-20200508163233305.png)

**类图**

![image-20200508162952876](/images/image-20200508162952876.png)

**难点1：Jetty的嵌入**

Server、ServletContextHandler、ServletHolder

> 代码位置`single.rpc.transport.HttpTransportServer#init`

**难点2:动态代理**

- Proxy.newProxyInstance
- RemoteInvoker implements InvocationHandle