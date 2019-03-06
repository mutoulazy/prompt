package practice.thread.std12;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier初始化时规定一个数目，然后计算调用了CyclicBarrier.await()进入等待的线程数。
 * 当线程数达到了这个数目时，所有进入等待状态的线程被唤醒并继续。
 */
public class CyclicBarrierDemo {

  public static void main(String[] args) {
    CyclicBarrier cyclicBarrier=new CyclicBarrier(5);
    for (int i = 0; i < 5; i++) {
      WriteThread writer = new WriteThread(cyclicBarrier);
      writer.start();
    }

  }

  static public class WriteThread extends Thread {
    private CyclicBarrier cyclicBarrier;

    public WriteThread(CyclicBarrier cyclicBarrier) {
      super();
      this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
      System.out.println("线程" + Thread.currentThread().getName() + ",正在写入数据");
      try {
        Thread.sleep(3000);
      } catch (Exception e) {
        // TODO: handle exception
      }
      System.out.println("线程" + Thread.currentThread().getName() + ",写入数据成功.....");

      try {
        cyclicBarrier.await();
      } catch (Exception e) {
      }
      System.out.println("所有线程执行完毕..........");
    }
  }
}
