package single.rpc.serialize;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.serialize
 * 类名称: JSONEncoderTest
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/30 14:12
 */
public class JSONEncoderTest {

    @Test
    public void encode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("JJ划水");
        bean.setAge(18);
        byte[] encode = encoder.encode(bean);
        assertNotNull(encode);
    }
}