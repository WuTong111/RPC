package single.rpc.serialize;

/**
 * 类作用: 序列化
 * 项目名称: s-rpc
 * 包: single.rpc.serialize
 * 类名称: Encoder
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/30 14:05
 */
public interface Encoder {
    byte[] encode(Object  obj);
}
