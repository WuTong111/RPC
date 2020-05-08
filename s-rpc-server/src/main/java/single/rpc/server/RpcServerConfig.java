package single.rpc.server;

import lombok.Data;
import single.rpc.serialize.Decoder;
import single.rpc.serialize.Encoder;
import single.rpc.serialize.JSONDecoder;
import single.rpc.serialize.JSONEncoder;
import single.rpc.transport.HttpTransportServer;
import single.rpc.transport.TransportServer;

/**
 * 类作用: server配置
 * 项目名称: s-rpc
 * 包: single.rpc.server
 * 类名称: RpcServerConfig
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/5/7 13:48
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HttpTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;


}
