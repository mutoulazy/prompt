package practice.io.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * socket服务端UDP
 */
public class UdpSocketServer {

  public static void main(String[] args) throws IOException {
    System.out.println("udp服务器端启动连接....");
    DatagramSocket ds = new DatagramSocket(8080);
    byte[] bytes = new byte[1024];
    DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
    // 阻塞,等待接受客户端发送请求
    ds.receive(dp);

    System.out.println("来源:"+dp.getAddress()+",端口号:"+dp.getPort());
    // 获取客户端请求内容
    String message = new String(dp.getData(), 0, dp.getLength());
    System.out.println("message: " + message);
    ds.close();
  }
}
