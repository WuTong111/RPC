package single.rpc;

import lombok.Data;

/**
 * 类作用: 表示RPC的返回
 * 项目名称: s-rpc
 * 包: single.rpc
 * 类名称: Response
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/29 17:36
 */
@Data
public class Response {
    /**
     * 服务返回编码，0-成功，非0失败
     */
    private int code = 0;
    /**
     * 具体的错误信息
     */
    private String message = "ok";
    /**
     * 返回的数据
     */
    private Object data;
}
