package practice.thread.std05;

/**
 * Volatile不具备原子性
 * AtomicInteger是一个提供原子操作的Integer类，通过线程安全的方式操作加减。
 */
public class VolatileNoAtomic {

  public static void main(String[] args) {
    VolatileNoAtomicDemo[] arr = new VolatileNoAtomicDemo[100];
    AtomicIntergeDemo[] arr2 = new AtomicIntergeDemo[100];

    for (int i = 0; i < 10; i++) {
      arr[i] = new VolatileNoAtomicDemo();
      arr2[i] = new AtomicIntergeDemo();
    }

    for (int i = 0; i < 10; i++) {
      // arr[i].start();
      arr2[i].start();
    }

  }

}
