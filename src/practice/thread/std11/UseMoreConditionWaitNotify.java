package practice.thread.std11;

public class UseMoreConditionWaitNotify {

  public static void main(String[] args) {
    MyserviceMoreCondition myserviceMoreCondition = new MyserviceMoreCondition();
    ThreadA threadA = new ThreadA(myserviceMoreCondition);
    ThreadA threadA2 = new ThreadA(myserviceMoreCondition);
    ThreadB threadB = new ThreadB(myserviceMoreCondition);
    threadA.setName("a");
    threadA.start();
    threadA2.setName("a2");
    threadA2.start();
    threadB.setName("b");
    threadB.start();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    myserviceMoreCondition.signalAll_A();
  }

  static public class ThreadA extends Thread {
    private MyserviceMoreCondition myserviceMoreCondition;

    public ThreadA(MyserviceMoreCondition myserviceMoreCondition) {
      super();
      this.myserviceMoreCondition = myserviceMoreCondition;
    }

    @Override
    public void run() {
      myserviceMoreCondition.awaitA();
    }
  }

  static public class ThreadB extends Thread {
    private MyserviceMoreCondition myserviceMoreCondition;

    public ThreadB(MyserviceMoreCondition myserviceMoreCondition) {
      super();
      this.myserviceMoreCondition = myserviceMoreCondition;
    }

    @Override
    public void run() {
      myserviceMoreCondition.awaitB();
    }
  }
}
