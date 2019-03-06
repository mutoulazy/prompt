package practice.thread.std05;

public class VolatileNoAtomicDemo extends Thread {
  private static volatile int count;

  private static void addCount() {
    for (int i = 0; i < 1000; i++) {
      count++;
    }
    System.out.println(count);
  }

  @Override
  public void run() {
    addCount();
  }
}

