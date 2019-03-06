package practice.io.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket服务端(tcp)
 */
public class TcpServer {

  public static void main(String[] args) throws IOException {
    System.out.println("socket tcp服务器端启动....");
    ServerSocket serverSocket = new ServerSocket(8080);
    // 等待客户端请求
    Socket accept = serverSocket.accept();
    InputStream inputStream = accept.getInputStream();
    // 转换成string类型
    byte[] buf = new byte[1024];
    int len = inputStream.read(buf);
    String message = new String(buf, 0 ,len);
    System.out.println("服务器接受客户端内容:" + message);
    serverSocket.close();
  }
}
