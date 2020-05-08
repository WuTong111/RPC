package single.rpc.example;

import single.rpc.client.RpcClient;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.example
 * 类名称: Client
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/5/8 14:26
 */
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);

        int add = service.add(1, 2);
        int minus = service.minus(1, 2);
        System.out.println(add);
        System.out.println(minus);
    }
}
