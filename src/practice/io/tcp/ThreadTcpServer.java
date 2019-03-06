package practice.io.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程socket服务端(tcp)
 */
public class ThreadTcpServer {

  public static void main(String[] args) throws IOException {
    System.out.println("socket t务器端启动....");
    ServerSocket serverSocket = new ServerSocket(8080);
    // 等待客户端请求
    try {
      while (true) {
        Socket accept = serverSocket.accept();
        new Thread(new Runnable() {
          @Override
          public void run() {
            try {
              InputStream inputStream = accept.getInputStream();
              byte[] buf = new byte[1024];
              int len = inputStream.read(buf);
              String message = new String(buf, 0, len);
              System.out.println("服务器接受客户端内容:" + message);
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }).start();

      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      serverSocket.close();
    }
  }
}
