package practice.io.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * socket客户端(tcp)
 */
public class TcpClient {

  public static void main(String[] args) throws UnknownHostException, IOException {
    System.out.println("socket tcp 客户端启动....");
    Socket socket = new Socket("127.0.0.1", 8080);
    OutputStream outputStream = socket.getOutputStream();
    outputStream.write("mutoulazy".getBytes());
    socket.close();
  }
}
