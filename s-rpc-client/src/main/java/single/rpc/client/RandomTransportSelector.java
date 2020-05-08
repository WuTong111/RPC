package single.rpc.client;

import lombok.extern.slf4j.Slf4j;
import single.rpc.Peer;
import single.rpc.common.ReflectionUtils;
import single.rpc.transport.TransportClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.client
 * 类名称: RandomTransportSelector
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/5/8 12:56
 */
@Slf4j
public class RandomTransportSelector implements TransportSelector {

    /**
     * 已经连接好的client
     */
    private List<TransportClient> clients;

    public RandomTransportSelector(){
        clients = new ArrayList<>();
    }


    @Override
    public synchronized void init(List<Peer> peers,
                     int count,
                     Class<? extends TransportClient> clazz) {
        count = Math.max(count, 1);

        for (Peer peer: peers) {
            for (int i=0;i<count;i++) {
                TransportClient client = ReflectionUtils.newInstance(clazz);
                client.connect(peer);
                clients.add(client);
            }
            log.info("connect server: {}", peer);
        }
    }

    @Override
    public synchronized TransportClient select() {
        int i= new Random().nextInt(clients.size());
        //获取一个连接
        return clients.get(i);
    }

    @Override
    public synchronized void release(TransportClient client) {
        clients.add(client);
    }

    @Override
    public synchronized void close() {
        for (TransportClient client : clients) {
            client.close();
        }
        clients.clear();
    }
}
