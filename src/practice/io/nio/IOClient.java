package practice.io.nio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * 模拟NIO客户端
 */
public class IOClient {

  public static void main(String[] args) {
    new Thread(() -> {
      try {
        Socket socket= new Socket("127.0.0.1", 3333);
        while (true) {
          try {
            socket.getOutputStream().write((new Date() + ": Hi Bio").getBytes());
            Thread.sleep(2000);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }).start();
  }
}
