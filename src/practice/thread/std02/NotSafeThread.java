package practice.thread.std02;

/**
 * 2个线程对同一数据源操作,非同步的情况下会导致对同一数据发生多次操作
 */
public class NotSafeThread {
  public static void main(String[] args) {
    ThreadSale threadSale = new ThreadSale();
    Thread thread1 = new Thread(threadSale, "Window1");
    Thread thread2 = new Thread(threadSale, "Window2");
    thread1.start();
    thread2.start();
  }

}
