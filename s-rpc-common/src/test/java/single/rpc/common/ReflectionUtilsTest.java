package single.rpc.common;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.common
 * 类名称: ReflectionUtilsTest
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/29 17:53
 */
public class ReflectionUtilsTest {

    @Test
    public void newInstance() {
        TestClass testClass = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(testClass);
    }

    @Test
    public void getPublicMethods() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        assertEquals(1, methods.length);
        String name = methods[0].getName();
        assertEquals("a", name);
    }

    @Test
    public void invoke() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        Method a = methods[0];
        TestClass testClass = ReflectionUtils.newInstance(TestClass.class);
        Object invoke = ReflectionUtils.invoke(testClass, a);
        assertEquals("a", invoke);

    }
}