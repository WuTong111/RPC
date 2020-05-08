package single.rpc.transport;

import org.apache.commons.io.IOUtils;
import single.rpc.Peer;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.transport
 * 类名称: HTTPTransportClient
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/30 14:35
 */
public class HTTPTransportClient implements TransportClient {
    private String url;

    @Override
    public void connect(Peer peer) {
        this.url = "http://" + peer.getHost() + ":" +peer.getPort();

    }

    @Override
    public InputStream write(InputStream data) {
        try {
            HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");

            conn.connect();
            IOUtils.copy(data, conn.getOutputStream());

            int resultCode = conn.getResponseCode();
            if (resultCode == HttpURLConnection.HTTP_OK) {
                return conn.getInputStream();
            } else {
                return conn.getErrorStream();
            }

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() {

    }
}
