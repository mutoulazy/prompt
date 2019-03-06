package practice.io.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程socket服务端(tcp)
 * 采用线程池优化
 */
public class ThreadPoolTcpServer {

  public static void main(String[] args) throws IOException {
    ExecutorService threadPool = Executors.newCachedThreadPool();
    System.out.println("socket tcp服务器端启动....");
    ServerSocket serverSocket = new ServerSocket(8080);
    // 等待客户端请求
    try {
      while (true) {
        Socket accpet = serverSocket.accept();
        //使用线程
        threadPool.execute(new Runnable() {
          @Override
          public void run() {
            try {
              InputStream inputStream = accpet.getInputStream();
              byte[] buf = new byte[1024];
              int len = inputStream.read(buf);
              String message = new String(buf, 0, len);
              System.out.println("服务器接受客户端内容:" + message);
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        });
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      serverSocket.close();
    }
  }
}
