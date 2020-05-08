package single.rpc.serialize;

import com.alibaba.fastjson.JSON;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.serialize
 * 类名称: JSONDecoder
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/30 14:10
 */
public class JSONDecoder implements Decoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
