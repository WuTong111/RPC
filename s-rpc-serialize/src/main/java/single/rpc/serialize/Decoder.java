package single.rpc.serialize;

/**
 * 类作用: 反序列化
 * 项目名称: s-rpc
 * 包: single.rpc.serialize
 * 类名称: Decoder
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/30 14:06
 */
public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}
