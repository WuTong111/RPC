package single.rpc.transport;

import single.rpc.Peer;

import java.io.InputStream;

/**
 * 类作用:
 * 1.创建连接
 * 2.发送数据，并且等待响应
 * 3.关闭连接
 *
 * 项目名称: s-rpc
 * 包: single.rpc.transport
 * 类名称: TransportClient
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/30 14:21
 */
public interface TransportClient {
    void connect(Peer peer);

    InputStream write(InputStream data);

    void close();
}
