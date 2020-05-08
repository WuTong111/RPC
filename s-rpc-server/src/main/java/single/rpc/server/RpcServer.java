package single.rpc.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import single.rpc.Request;
import single.rpc.Response;
import single.rpc.common.ReflectionUtils;
import single.rpc.serialize.Decoder;
import single.rpc.serialize.Encoder;
import single.rpc.transport.RequestHandler;
import single.rpc.transport.TransportServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.server
 * 类名称: RpcServer
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/5/7 18:07
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    public RpcServer() {
    }
    public RpcServer(RpcServerConfig config){
        this.config = config;
        //net
        this.net = ReflectionUtils.newInstance(
                config.getTransportClass());
        this.net.init(config.getPort(), this.handler);


        this.encoder = ReflectionUtils.newInstance(
                config.getEncoderClass());
        this.decoder =  ReflectionUtils.newInstance(
                config.getDecoderClass());

        //service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();

    }

    public <T> void register(Class<T> interfaceClass, T bean) {
        serviceManager.register(interfaceClass, bean);
    }

    public void start(){
        this.net.start();
    }
    public void stop(){
        this.net.stop();
    }
    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream recive, OutputStream toResp) {
            Response response = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(recive, recive.available());
                Request request = decoder.decode(inBytes, Request.class);
                log.info("get request: {}",request);

                ServiceInstance instance = serviceManager.lookup(request);
                Object invoke = serviceInvoker.invoke(instance, request);
                response.setData(invoke);

            } catch (Exception e) {
                log.warn(e.getMessage(), e);
                response.setCode(1);
                response.setMessage("RpcServer got error:"+e.getClass().getName()
                +" : " + e.getMessage());
            }finally {
                try {
                    byte[] outBytes = encoder.encode(response);
                    toResp.write(outBytes);

                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            }
        }
    };
}
