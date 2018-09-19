package prompt.Thread.thread_notifyall;

/**
 * 线程交互（notifyAll（））
 * Created by mutoulazy on 2017/10/12.
 */
public class ResultThread extends Thread{
    CountThread countThread;

    public ResultThread(CountThread countThread){
        this.countThread = countThread;
    }


    /**
     * 实际上，上面这个代码中，我们期望的是读取结果的线程在计算线程调用notifyAll()之前等待即可。
     * 但是，如果计算线程先执行，并在读取结果线程等待之前调用了notify()方法，那么又会发生什么呢？这种情况是可能发生的。
     * 因为无法保证线程的不同部分将按照什么顺序来执行。幸运的是当读取线程运行时，
     * 它只能马上进入等待状态----它没有做任何事情来检查等待的事件是否已经发生。
     * 因此，如果计算线程已经调用了notifyAll()方法，那么它就不会再次调用notifyAll()，
     * 并且等待的读取线程将永远保持等待。这当然是开发者所不愿意看到的问题。
     */
    public static void main(String[] args) {
        CountThread countThread1 = new CountThread();

        //启动三个线程获取结果
        new ResultThread(countThread1).start();
        new ResultThread(countThread1).start();
        new ResultThread(countThread1).start();

        //启动计算线程
        countThread1.start();
    }

    /**
     * 获取计算结果线程
     */
    @Override
    public void run() {
        synchronized (countThread){
            try {
                System.out.println("线程： "+Thread.currentThread()+"等待计算结果");
                countThread.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("线程:"+ Thread.currentThread() +"计算结果为" + countThread.total);
        }
    }
}
