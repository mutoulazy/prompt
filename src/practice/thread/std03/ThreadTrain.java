package practice.thread.std03;

public class ThreadTrain implements Runnable {

  private int count = 100;
  public boolean flag = true;
  private Object mutex = new Object();

  @Override
  public void run() {
    if (flag) {
      while (true) {
        synchronized (mutex) {
          sale();
        }
      }
    } else {
      while (true) {
        sale();
      }
    }
  }

  public synchronized void sale() {
    synchronized (mutex) {
      if (count > 0) {
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ",出售 第" + (100 - count + 1) + "张票.");
        count --;
      }
    }
  }
}
