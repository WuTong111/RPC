package single.rpc.transport;

import jdk.internal.util.xml.impl.Input;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 类作用: 处理网络请求的handle
 * 项目名称: s-rpc
 * 包: single.rpc.transport
 * 类名称: RequestHandler
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/30 14:32
 */
public interface RequestHandler {
    void onRequest(InputStream recive, OutputStream toRespon);

}
