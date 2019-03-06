package practice.thread.std07;

public class OutThread extends Thread {
  private Res res;

  public OutThread(Res res) {
    this.res = res;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (res) {
        if (!res.flag) {
          try {
            res.wait();
          } catch (Exception e) {
            // TODO: handle exception
          }
        }
        System.out.println(res.userName + "," + res.userSex);
        res.flag = false;
        res.notify();
      }
    }

  }
}
