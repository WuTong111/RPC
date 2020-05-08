package single.rpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * 类作用: 表示一个具体服务
 * 项目名称: s-rpc
 * 包: single.rpc.server
 * 类名称: ServiceInstance
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/5/7 13:55
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    private Object target;
    private Method method;

}
