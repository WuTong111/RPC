package single.rpc.client;

import lombok.Data;
import single.rpc.Peer;
import single.rpc.serialize.Decoder;
import single.rpc.serialize.Encoder;
import single.rpc.serialize.JSONDecoder;
import single.rpc.serialize.JSONEncoder;
import single.rpc.transport.HTTPTransportClient;
import single.rpc.transport.TransportClient;

import java.util.Arrays;
import java.util.List;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.client
 * 类名称: RpcClientConfig
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/5/8 13:04
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass =
            HTTPTransportClient.class;

    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass =
            RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(
            new Peer("127.0.0.1",3000)
    );


}
