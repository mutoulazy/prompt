package practice.thread.std07;

public class Test {

  public static void main(String[] args) {
    Res res = new Res();
    IntThread intThread = new IntThread(res);
    OutThread outThread = new OutThread(res);

    intThread.start();
    outThread.start();
  }
}
