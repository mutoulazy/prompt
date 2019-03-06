package practice.thread.std04;

// volatile 关键字使变量在线程之间"可见"
public class ThreadVolatile {

  public static void main(String[] args) {
    ThreadVolatileDemo threadVolatileDemo = new ThreadVolatileDemo();
    threadVolatileDemo.start();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("set flag false");
    threadVolatileDemo.setFlag(false);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(threadVolatileDemo.flag);
  }

}
