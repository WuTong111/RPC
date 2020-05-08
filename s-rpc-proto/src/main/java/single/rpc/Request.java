package single.rpc;

import lombok.Data;

/**
 * 类作用: 表示RPC的一个请求
 * 项目名称: s-rpc
 * 包: single.rpc
 * 类名称: Request
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/29 17:34
 */
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;

}
