package practice.thread.std03;

/**
 * 在同步中套用同步 往往会造成死锁
 */
public class deadlock {

  public static void main(String[] args) {
    ThreadTrain threadTrain = new ThreadTrain();
    Thread thread1 = new Thread(threadTrain, "Window1");
    Thread thread2 = new Thread(threadTrain, "Window2");

    thread1.start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    threadTrain.flag = false;
    thread2.start();
  }
}
