package single.rpc.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 类作用: 反射工具类
 * 项目名称: s-rpc
 * 包: single.rpc.common
 * 类名称: ReflectionUtils
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/29 17:39
 */
public class ReflectionUtils {

    /**
     * 根据class创建对象
     *
     * @param clazz 带创建对象的类
     * @param <T> 对象类型
     * @return 创建好的类
     */
    public static <T> T newInstance(Class<T> clazz){
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     *  获取class的公有方法
     * @param clazz class
     * @return class的公有方法
     */
    public static Method[] getPublicMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> pMethods = new ArrayList<Method>();
        //过滤出公共方法
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                pMethods.add(method);
            }
        }
        return pMethods.toArray(new Method[0]);
    }

    /**
     * 调用指定对象的指定方法
     *
     * @param obj 被调用方法的对象
     * @param method 被调用的方法
     * @param args 方法的参数
     * @return 返回结果
     */
    public static Object invoke(Object obj, Method method, Object... args) {
        try {
            return method.invoke(obj, args);
        }  catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
