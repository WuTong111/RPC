package single.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 类作用: 表示网络传输的一个端点
 * 项目名称: s-rpc
 * 包: single.rpc
 * 类名称: Peer
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/29 17:31
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}
