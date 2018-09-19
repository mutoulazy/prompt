package prompt.Thread.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newSingleThreadExecutor
 * 创建一个单线程的线程池。
 * 这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。
 * 如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。
 * 此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
 * Created by mutoulazy on 2017/10/13.
 */
public class TestSingleThreadExecutor {
    public static void main(String[] args) {
        //创建一个可重用的固定数量的线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();

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
