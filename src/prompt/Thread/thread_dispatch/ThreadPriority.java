package prompt.Thread.thread_dispatch;

/**
 * 线程调度之优先级
 * Created by mutoulazy on 2017/10/12.
 */
public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new MyThread2();
        Thread t2 = new Thread(new MyRunnable());
        //设置优先级
        t1.setPriority(10);
        t2.setPriority(1);

        t2.start();
        t1.start();
    }
}

class MyThread2 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("线程1第" + i + "次执行！");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
