package practice.thread.std02;

public class ThreadSale implements Runnable {
  private int count = 100;
  private static Object oj = new Object();

  @Override
  public void run() {
    while (count>0) {
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      sale();
    }
  }

  // public void sale() {
  //   // 同步代码块
  //   synchronized (oj) {
  //     if (count>0) {
  //       System.out.println(Thread.currentThread().getName() + " sale " + (100 - count + 1));
  //       count --;
  //     }
  //   }
  // }

  // 同步函数 this明锁
  public synchronized void sale() {
    if (count>0) {
      System.out.println(Thread.currentThread().getName() + " sale " + (100 - count + 1));
      count --;
    }

  }
}
