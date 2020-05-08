package single.rpc.example;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.example
 * 类名称: CalcServiceImpl
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/5/8 14:28
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
