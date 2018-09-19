package prompt.Thread.thread_notifyall;

/**
 * 计算线程
 * Created by mutoulazy on 2017/10/12.
 */
public class CountThread extends Thread{
    int total;

    @Override
    public void run() {
        synchronized (this){
            for (int i=0;i<101;i++){
                total += i;
            }
        }
        //计算完成 通知所有等待的线程
        System.out.println("线程计算完成，唤醒");
        notifyAll();
    }
}
