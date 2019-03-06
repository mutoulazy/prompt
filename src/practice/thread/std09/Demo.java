package practice.thread.std09;

public class Demo {

  public static void main(String[] args) {
    StopThread stopThread = new StopThread();
    Thread thread1 = new Thread(stopThread);
    Thread thread2 = new Thread(stopThread);

    thread1.start();
    thread2.start();
    int i = 0;
    while (true) {
      System.out.println("thread run..");
      if (i == 300) {
        thread1.interrupt();
        thread2.interrupt();
        break;
      }
      i ++;
    }
  }
}
