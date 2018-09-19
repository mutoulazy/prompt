package prompt.Thread.thread_dispatch;

/**
 * 线程调度之守护线程
 * Created by mutoulazy on 2017/10/12.
 */
public class ThreadDaemon {

    /*
    前台线程是保证执行完毕的，后台线程还没有执行完毕就退出了。
    实际上：JRE判断程序是否执行结束的标准是所有的前台执线程行完毕了，而不管后台线程的状态，
    因此，在使用后台线程时候一定要注意这个问题。
     */
    public static void main(String[] args) {
        Thread t1 = new MyThread2();
        Thread t2 = new Thread(new MyDaemon());
        t2.setDaemon(true);        //设置为守护线程

        t2.start();
        t1.start();
    }
}

class MyDaemon implements Runnable {
    public void run() {
        for (long i = 0; i < 9999999L; i++) {
            System.out.println("后台线程第" + i + "次执行！");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
