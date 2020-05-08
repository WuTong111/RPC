package single.rpc.serialize;

import com.alibaba.fastjson.JSON;

/**
 * 类作用: 基于json的序列化实现
 * 项目名称: s-rpc
 * 包: single.rpc.serialize
 * 类名称: JSONEncoder
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/30 14:09
 */
public class JSONEncoder implements Encoder {

    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
