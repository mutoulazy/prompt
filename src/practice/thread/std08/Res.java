package practice.thread.std08;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Res {
  public String userName;
  public String sex;
  public boolean flag = false;
  Lock lock = new ReentrantLock();
}
