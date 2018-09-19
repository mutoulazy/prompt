package prompt.Thread.thread_dispatch;

/**
 * 线程调度之线程让步
 * Created by mutoulazy on 2017/10/12.
 */
public class ThreadYield {
    public static void main(String[] args) {
        Thread t1 = new MyThread3();
        Thread t2 = new Thread(new MyRunnable1());

        t2.start();
        t1.start();
    }
}

class MyThread3 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("线程1第" + i + "次执行！");
        }
    }
}

class MyRunnable1 implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            //线程让步
            Thread.yield();
            System.out.println("线程2第" + i + "次执行！");
        }
    }
}
