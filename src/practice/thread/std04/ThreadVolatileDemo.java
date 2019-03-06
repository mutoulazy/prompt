package practice.thread.std04;

public class ThreadVolatileDemo extends Thread {
  // 如果不适用volatile关键字 在主进程设置flag为false后进程仍然不会停止
  // 使用Volatile关键字将解决线程之间可见性, 强制线程每次读取该值的时候都去“主内存”中取值
  // public volatile boolean flag = true;

  public boolean flag = true;

  @Override
  public void run() {
    System.out.println("start..........");
    while (flag) {

    }
    System.out.println("stop...........");
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }
}
