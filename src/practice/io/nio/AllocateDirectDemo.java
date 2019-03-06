package practice.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 直接缓冲区与非直接缓冲区
 *    非直接缓冲区：通过 allocate() 方法分配缓冲区，将缓冲区建立在 JVM 的内存中
 *    直接缓冲区：通过 allocateDirect() 方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率
 */
public class AllocateDirectDemo {

  public static void main(String[] args) {
    try {
      // testAllocateDirect();
      testAllocate();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 直接缓冲区 耗时72
  private static void testAllocateDirect() throws IOException {
    long start = System.currentTimeMillis();
    FileChannel inChannel = FileChannel.open(Paths.get("d:\\1.avi"), StandardOpenOption.READ);
    FileChannel outChannel = FileChannel.open(Paths.get("d:\\2.avi"), StandardOpenOption.WRITE,
        StandardOpenOption.READ, StandardOpenOption.CREATE);
    // 内存映射文件
    MappedByteBuffer inMappedByteBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
    MappedByteBuffer outMappedByteBuffer = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
    // 直接对缓冲区进行数据的读写操作
    byte[] bytes = new byte[inMappedByteBuffer.limit()];
    inMappedByteBuffer.get(bytes);
    outMappedByteBuffer.put(bytes);
    inChannel.close();
    outChannel.close();
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }

  // 非直接缓冲区 耗时570
  private static void testAllocate() throws IOException {
    long start = System.currentTimeMillis();
    FileInputStream fis = new FileInputStream("d:\\1.avi");
    FileOutputStream fos = new FileOutputStream("d:\\2.avi");
    // 获取通道
    FileChannel inChannel = fis.getChannel();
    FileChannel outChannel = fos.getChannel();
    // 分配指定大小的缓冲区
    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    while (inChannel.read(byteBuffer) != -1) {
      byteBuffer.flip();
      outChannel.write(byteBuffer);
      byteBuffer.clear();
    }
    outChannel.close();
    inChannel.close();
    fos.close();
    fis.close();
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }
}
