package practice.thread.std08;

import java.util.concurrent.locks.Condition;

public class OuterThread extends Thread{
  private Res res;
  private Condition newCondition;

  public OuterThread(Res res,Condition condition) {
    this.res = res;
    this.newCondition = condition;
  }

  @Override
  public void run() {
    while (true) {
      try{
        res.lock.lock();
        if (!res.flag) {
          try {
            res.wait();
            newCondition.await();
          } catch (Exception e) {

          }
        }
        System.out.println(res.userName + "," + res.sex);
        res.flag = false;
        res.notify();
        newCondition.signal();
      }catch (Exception e) {

      }finally {
        res.lock.unlock();
      }
    }
  }
}
