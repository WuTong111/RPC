package single.rpc.server;

import lombok.extern.slf4j.Slf4j;
import single.rpc.Request;
import single.rpc.ServiceDescriptor;
import single.rpc.common.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类作用: 管理rpc暴露的服务
 * 项目名称: s-rpc
 * 包: single.rpc.server
 * 类名称: ServiceManager
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/5/7 13:56
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor, ServiceInstance> services;

    public ServiceManager(){
        this.services = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfaceClass, T bean) {
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass, method);
            services.put(sdp, sis);
            log.info("register service:{} {}", sdp.getClazz(), sdp.getMethod());
        }
    }

    public ServiceInstance lookup(Request request) {
        ServiceDescriptor sdp = request.getService();
        return services.get(sdp);
    }
}
