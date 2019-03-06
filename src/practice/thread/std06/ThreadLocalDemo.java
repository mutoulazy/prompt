package practice.thread.std06;

/**
 * ThreadLocal 使每个线程有自己局部变量
 */
public class ThreadLocalDemo extends Thread{
  private Res res;

  public ThreadLocalDemo(Res res) {
    this.res = res;
  }

  @Override
  public void run() {
    for (int i = 0; i < 3; i++) {
      System.out.println(Thread.currentThread().getName() + "---" + "i---" + i + "--num:" + res.getNum());
    }
  }

  public static void main(String[] args) {
    Res res = new Res();
    ThreadLocalDemo threadLocaDemo1 = new ThreadLocalDemo(res);
    ThreadLocalDemo threadLocaDemo2 = new ThreadLocalDemo(res);
    ThreadLocalDemo threadLocaDemo3 = new ThreadLocalDemo(res);
    threadLocaDemo1.start();
    threadLocaDemo2.start();
    threadLocaDemo3.start();
  }
}
