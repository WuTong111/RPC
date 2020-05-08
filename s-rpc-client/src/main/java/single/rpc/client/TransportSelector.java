package single.rpc.client;

import single.rpc.Peer;
import single.rpc.transport.TransportClient;

import java.util.List;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.client
 * 类名称: TransportSelector
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/5/8 12:49
 */
public interface TransportSelector {

    /**
     * 初始化selector
     *
     * @param peers 可以连接的server端点信息
     * @param count client于server建立多少个连接
     * @param clazz client实现的class
     */
    void init(List<Peer> peers, int count, Class<? extends TransportClient> clazz);
    /**
     * 选择一个transport于server做交互
     *
     * @return 网络client
     */
    TransportClient select();

    /**
     * 释放用完的client
     */
    void release(TransportClient client);

    void close();

}
