package practice.io.nio;

import java.nio.ByteBuffer;

/**
 * nio中的Buffer类的Mark与Reset方法Demo
 *  标记（mark）与重置（reset）：标记是一个索引，通过Buffer中的mark()方法指定Buffer中一个特定的position，
 *  之后可以通过调用reset()方法恢复到这个position
 */
public class MarkAndReset {

  public static void main(String[] args) {
    ByteBuffer buf = ByteBuffer.allocate(1024);
    String str = "mutou";
    buf.put(str.getBytes());
    // 开启读取模式
    buf.flip();
    byte[] bytes = new byte[buf.limit()];
    buf.get(bytes, 0, 2);
    buf.mark();
    System.out.println(new String(bytes, 0, 2));
    System.out.println(buf.position());
    buf.get(bytes, 2, 2);
    System.out.println(new String(bytes, 2, 2));
    System.out.println(buf.position());
    buf.reset();
    System.out.println("重置恢复到mark位置..");
    System.out.println(buf.position());
  }
}
