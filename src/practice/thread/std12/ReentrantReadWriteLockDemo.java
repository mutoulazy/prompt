package practice.thread.std12;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

  public static void main(String[] args) {
    MyService service = new MyService();
    MyThread thread1 = new MyThread(service);
    MyThreadB thread2 = new MyThreadB(service);
    thread1.start();
    thread2.start();
  }

  static public class MyThread extends Thread {

    private MyService service;

    public MyThread(MyService service) {
      super();
      this.service = service;
    }

    @Override
    public void run() {
      service.Read();
    }
  }

  static public class MyThreadB extends Thread {

    private MyService service;

    public MyThreadB(MyService service) {
      super();
      this.service = service;
    }

    @Override
    public void run() {
      service.Write();
    }
  }

  static public class MyService {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void Read() {
      try {
        try {
          lock.readLock().lock(); // 读锁共享
          // lock.writeLock().lock(); // 写锁互斥
          System.out.println("获得读锁" + Thread.currentThread().getName()
              + " " + System.currentTimeMillis());
          Thread.sleep(10000);
        } finally {
          lock.readLock().unlock();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    public void Write() {
      try {
        try {
          lock.writeLock().lock();
          System.out.println("获得写锁" + Thread.currentThread().getName()
              + " " + System.currentTimeMillis());
          Thread.sleep(10000);
        } finally {
          lock.writeLock().unlock();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
