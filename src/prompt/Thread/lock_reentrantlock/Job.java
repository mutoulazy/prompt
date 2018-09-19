package prompt.Thread.lock_reentrantlock;

/**
 * Created by mutoulazy on 2017/10/20.
 */
public class Job implements Runnable {
    private PrintQueue queue;

    public Job(PrintQueue printQueue){
        this.queue = printQueue;
    }

    @Override
    public void run() {
        queue.printJob(new Object());
    }
}
