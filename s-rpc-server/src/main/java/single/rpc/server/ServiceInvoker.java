package single.rpc.server;

import single.rpc.Request;
import single.rpc.common.ReflectionUtils;

/**
 * 类作用: 调用具体服务
 * 项目名称: s-rpc
 * 包: single.rpc.server
 * 类名称: ServiceInvoker
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/5/7 18:04
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance instance, Request request) {
        return ReflectionUtils.invoke(
                instance.getTarget(),
                instance.getMethod(),
                request.getParameters()
        );
    }
}
