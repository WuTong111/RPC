package single.rpc.client;

import single.rpc.common.ReflectionUtils;
import single.rpc.serialize.Decoder;
import single.rpc.serialize.Encoder;

import java.lang.reflect.Proxy;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.client
 * 类名称: RpcClient
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/5/8 13:55
 */
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient(RpcClientConfig config) {
        this.config = config;

        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(this.config.getSelectorClass());

        this.selector.init(
                this.config.getServers(),
                this.config.getConnectCount(),
                this.config.getTransportClass()
        );
    }
    public RpcClient() {
        this(new RpcClientConfig());
    }

    public <T> T getProxy(Class<T> clazz){
        return (T) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{clazz},
                new RemoteInvoker(clazz, encoder, decoder, selector)
        );
    }
}
