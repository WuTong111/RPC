package single.rpc.serialize;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.serialize
 * 类名称: JSONDecoderTest
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/30 14:15
 */
public class JSONDecoderTest {

    @Test
    public void decode() {
        Encoder encoder = new JSONEncoder();
        Decoder decoder = new JSONDecoder();
        TestBean bean = new TestBean();
        bean.setName("JJ划水");
        bean.setAge(18);
        byte[] encode = encoder.encode(bean);


        TestBean decode = decoder.decode(encode, TestBean.class);
        assertEquals(decode.getName(),bean.getName());
        assertEquals(decode.getAge(), bean.getAge());
    }
}