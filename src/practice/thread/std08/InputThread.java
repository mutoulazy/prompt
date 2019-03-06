package practice.thread.std08;

import java.util.concurrent.locks.Condition;

public class InputThread extends Thread {
  private Res res;
  Condition newCondition;

  public InputThread(Res res, Condition condition) {
    this.res = res;
    this.newCondition = condition;
  }

  @Override
  public void run() {
    int count = 0;
    while (true) {
      try {
        res.lock.lock();
        if (res.flag) {
          try {
            res.wait();
            newCondition.await();
          } catch (Exception e) {

          }
        }
        if (count == 0) {
          res.userName = "aaa";
          res.sex = "aaaSex";
        } else {
          res.userName = "bbb";
          res.sex = "bbbSex";
        }
        count = (count + 1) % 2;
        res.flag = true;
        res.notify();
        newCondition.signal();
      } catch (Exception e) {

      } finally {
        res.lock.unlock();
      }
    }
  }
}
