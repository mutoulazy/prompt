package practice.io.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 分散读与聚集写入
 */
public class ScatteringReadAndGatheringWrite {

  public static void main(String[] args) throws Exception{
    RandomAccessFile raf1 = new RandomAccessFile("d:\\test.txt", "rw");
    // 获取通道
    FileChannel fileChannel = raf1.getChannel();
    // 分配指定大小的指定缓冲区
    ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
    ByteBuffer byteBuffer2 = ByteBuffer.allocate(100);
    // 分散读取
    ByteBuffer[] bufs = {byteBuffer1, byteBuffer2};
    fileChannel.read(bufs);
    for (ByteBuffer byteBuffer : bufs) {
      // 切换为读取模式
      byteBuffer.flip();
    }
    System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
    System.out.println("------------------分算读取线分割--------------------");
    System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));
    // 聚集写入
    RandomAccessFile raf2 = new RandomAccessFile("d:\\1.txt", "rw");
    FileChannel fileChannel2 = raf2.getChannel();
    fileChannel2.write(bufs);
  }
}
