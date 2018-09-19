package prompt.Thread.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool
 * 创建固定大小的线程池。
 * 每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
 * 线程池的大小一旦达到最大值就会保持不变，
 * 如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
 * Created by mutoulazy on 2017/10/13.
 */
public class TestFixedThreadPool {
    public static void main(String[] args) {
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);

        //创建线程
        Thread t1 = new PublicClassMyThread();
        Thread t2 = new PublicClassMyThread();
        Thread t3 = new PublicClassMyThread();
        Thread t4 = new PublicClassMyThread();
        Thread t5 = new PublicClassMyThread();

        //把线程放入线程池中执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        //关闭线程池
        pool.shutdown();
    }
}
