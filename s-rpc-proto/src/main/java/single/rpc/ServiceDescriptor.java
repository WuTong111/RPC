package single.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 类作用: 表示服务
 * 项目名称: s-rpc
 * 包: single.rpc
 * 类名称: ServiceDescriptor
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/29 17:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDescriptor {
    private String clazz;
    private String method;
    private String returnType;
    private String[] parameterTypes;

    public static ServiceDescriptor from(Class clazz, Method method) {
        ServiceDescriptor sdp = new ServiceDescriptor();
        sdp.setClazz(clazz.getName());
        sdp.setMethod(method.getName());
        sdp.setReturnType(method.getReturnType().getName());

        Class<?>[] parameterClasses= method.getParameterTypes();
        String[] parameterTypes = new String[parameterClasses.length];
        for (int i=0; i<parameterClasses.length; i++) {
            parameterTypes[i] =  parameterClasses[i].getName();
        }
        sdp.setParameterTypes(parameterTypes);

        return sdp;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ServiceDescriptor that = (ServiceDescriptor) obj;

        return this.toString().equals(that.toString());
    }

    @Override
    public String toString() {
        return "clazz=" + clazz
                + ",method=" + method
                + ",returnType=" + returnType
                + ",parameterTypes=" + Arrays.toString(parameterTypes);
    }
}
