package single.rpc.transport;


import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 类作用: todo
 * 项目名称: s-rpc
 * 包: single.rpc.transport
 * 类名称: HttpTransportServer
 * 类描述: 类功能详细描述
 * 作者: wuguang
 * 创建时间:  2020/4/30 15:06
 */
@Slf4j
public class HttpTransportServer implements TransportServer {

    private RequestHandler handler;
    private Server server;

    @Override
    public void init(int port, RequestHandler handler) {
        this.handler = handler;
        // **1.嵌入Jetty.Server
        this.server = new Server(port);

        //**2.创建Jetty.ServletContextHandler  servlet 接受请求
        ServletContextHandler ctx = new ServletContextHandler();
        //注册在server中
        server.setHandler(ctx);

        //**3.创建Jetty.ServletHolder  托管RequestServlet
        ServletHolder holder = new ServletHolder(new RequestServlet());
        ctx.addServlet(holder, "/*");
    }

    @Override
    public void start() {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    class RequestServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            log.info("client connect");

            InputStream in = request.getInputStream();
            OutputStream out = response.getOutputStream();

            if (handler != null) {
                handler.onRequest(in, out);
            }

            out.flush();
        }
    }
}
