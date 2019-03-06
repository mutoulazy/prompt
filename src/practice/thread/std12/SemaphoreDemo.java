package practice.thread.std12;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore可以实现线程池
 */
public class SemaphoreDemo {

  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(3);
    for (int i = 1; i <=10; i++) {
      Parent parent = new Parent("第"+i+"个人,",semaphore);
      new Thread(parent).start();
    }

  }

  static public class Parent implements Runnable {
    private String name;
    private Semaphore wc;

    public Parent(String name, Semaphore wc) {
      this.name = name;
      this.wc = wc;
    }

    @Override
    public void run() {
      try {
        int availablePermits = wc.availablePermits();
        if (availablePermits > 0) {
          System.out.println(name+"有空余 可以进行");
        } else {
          System.out.println(name+"无位置");
        }

        wc.acquire();
        System.out.println(name+"in WC");
        Thread.sleep(new Random().nextInt(1000));
        System.out.println(name+"out WC...");
        wc.release();

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
