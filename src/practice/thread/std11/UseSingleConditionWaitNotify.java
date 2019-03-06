package practice.thread.std11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseSingleConditionWaitNotify {

  public static void main(String[] args) {
    MyService service = new MyService();
    MyThread thread = new MyThread(service);
    thread.start();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    service.signal();
  }

  static public class MyService {
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public void await() {
      lock.lock();
      try {
        System.out.println(" await时间为" + System.currentTimeMillis());
        condition.await();
        System.out.println("这是condition.await()方法之后的语句，condition.signal()方法之后才被执行");
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }

    public void signal() {
      lock.lock();
      try {
        System.out.println("signal时间为" + System.currentTimeMillis());
        condition.signal();
        Thread.sleep(3000);
        System.out.println("这是condition.signal()方法之后的语句");
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }

  static public class MyThread extends Thread {
    private MyService service;

    public MyThread(MyService service) {
      super();
      this.service = service;
    }

    @Override
    public void run() {
      service.await();
    }
  }

}
