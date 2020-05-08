package single.rpc.server;

import org.junit.Before;
import org.junit.Test;
import single.rpc.Request;
import single.rpc.ServiceDescriptor;
import single.rpc.common.ReflectionUtils;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.server
 * 类名称: ServiceManagerTest
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/5/7 14:31
 */
public class ServiceManagerTest {

    ServiceManager sm;
    @Before
    public void init(){
        sm = new ServiceManager();
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }
    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    @Test
    public void lookup() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestInterface.class);
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, methods[0]);
        Request request = new Request();
        request.setService(sdp);
        ServiceInstance lookup = sm.lookup(request);
        assertNotNull(lookup);
    }
}