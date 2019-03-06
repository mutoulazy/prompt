package practice.thread.std01;

/**
 * join调整Thread的执行顺序
 */
public class JoinThreadDemo {

  public static void main(String[] args) {
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println("t1,i:" + i);
        }
      }
    });
    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          t1.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
          System.out.println("t2,i:" + i);
        }
      }
    });
    Thread t3 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          t2.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
          System.out.println("t3,i:" + i);
        }
      }
    });
    t1.start();
    t2.start();
    t3.start();
  }

}
