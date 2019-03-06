package practice.thread.std05;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntergeDemo extends Thread {
  private static AtomicInteger atomicInteger = new AtomicInteger(0);

  private static void addCount() {
    for (int i = 0; i < 1000; i++) {
      atomicInteger.incrementAndGet();
    }
    System.out.println(atomicInteger.get());
  }

  @Override
  public void run() {
    addCount();
  }
}
