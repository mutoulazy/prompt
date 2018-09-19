package prompt.Thread.thread_notify;

/**
 * 线程唤醒
 * Created by mutoulazy on 2017/10/12.
 */
public class ThreadB extends Thread {
    int total;

    @Override
    public void run() {
        synchronized (this){
            for (int i=0;i<101;i++){
                total += i;
            }
            //计算完成后唤醒在对象监视器上等待的单个线程，在本例子中A线程被唤醒。
            System.out.println("已完成计算，唤醒A线程");
            notify();
        }
    }
}
