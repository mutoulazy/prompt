package practice.thread.std12;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch计数器为0时 才继续执行
 */
public class CountDownLatchDemo {

  public static void main(String[] args) {
    System.out.println("等待子线程执行完毕...");
    CountDownLatch countDownLatch = new CountDownLatch(2);
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("子线程," + Thread.currentThread().getName() + "开始执行...");
        countDownLatch.countDown();// 每次减去1
        System.out.println("子线程," + Thread.currentThread().getName() + "结束执行...");
      }
    }).start();
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("子线程," + Thread.currentThread().getName() + "开始执行...");
        countDownLatch.countDown();// 每次减去1
        System.out.println("子线程," + Thread.currentThread().getName() + "结束执行...");
      }
    }).start();

    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("两个子线程执行完毕....");
    System.out.println("继续主线程执行..");
  }
}
