package practice.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * 字符集
 * 编码：字符串->字节数组
 * 解码：字节数组 -> 字符串
 */
public class CharsetDemo {

  public static void main(String[] args) throws Exception {
    // 获取字符集
    Charset cs1 = Charset.forName("GBK");
    // 获取编码器
    CharsetEncoder ce = cs1.newEncoder();
    // 获取解码器
    CharsetDecoder cd = cs1.newDecoder();

    CharBuffer cBuf = CharBuffer.allocate(1024);
    cBuf.put("木头");
    cBuf.flip();

    // 编码
    ByteBuffer bBuf = ce.encode(cBuf);
    for (int i = 0; i < 4; i++) {
      System.out.println(bBuf.get());
    }
    // 解码
    bBuf.flip();
    CharBuffer cBuf2 = cd.decode(bBuf);
    System.out.println(cBuf2.toString());
    System.out.println("-------------------------------------");
    Charset cs2 = Charset.forName("GBK");
    bBuf.flip();
    CharBuffer cbeef = cs2.decode(bBuf);
    System.out.println(cbeef.toString());


  }
}
