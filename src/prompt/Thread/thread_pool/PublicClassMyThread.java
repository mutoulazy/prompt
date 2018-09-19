package prompt.Thread.thread_pool;

/**
 * Created by mutoulazy on 2017/10/13.
 */
public class PublicClassMyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程正在执行----");
    }
}
