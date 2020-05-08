package single.rpc.transport;

/**
 * 类作用:
 * 1.启动 监听端口
 * 2.接受请求
 * 3.关闭监听
 *
 * 项目名称: s-rpc
 * 包: single.rpc.transport
 * 类名称: TransportServer
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/30 14:31
 */
public interface TransportServer {
    void init(int port, RequestHandler handler);
    void start();

    void stop();
}
