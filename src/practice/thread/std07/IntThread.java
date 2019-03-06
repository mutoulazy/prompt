package practice.thread.std07;

public class IntThread extends Thread{
  private Res res;

  public IntThread(Res res) {
    this.res = res;
  }

  @Override
  public void run() {
    int count = 0;
    while (true) {
      synchronized (res) {
        if (res.flag) {
          try {
            res.wait();
          } catch (Exception e) {
            // TODO: handle exception
          }
        }
        if (count == 0) {
          res.userName = "aaa";
          res.userSex = "aaaSex";
        } else {
          res.userName = "bbb";
          res.userSex = "bbbSex";
        }
        count = (count + 1) % 2;
        res.flag = true;
        res.notify();
      }

    }
  }
}
