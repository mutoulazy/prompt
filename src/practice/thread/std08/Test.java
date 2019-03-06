package practice.thread.std08;

import java.util.concurrent.locks.Condition;

public class Test {

  public static void main(String[] args) {
    Res res = new Res();
    Condition condition = res.lock.newCondition();
    InputThread inputThread = new InputThread(res, condition);
    OuterThread outerThread = new OuterThread(res, condition);

    inputThread.start();
    outerThread.start();
  }
}
