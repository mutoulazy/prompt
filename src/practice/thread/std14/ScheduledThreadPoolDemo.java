package practice.thread.std14;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import practice.thread.std14.ThreadPoolExecutorDemo.WorkerThread;

public class ScheduledThreadPoolDemo {

  public static void main(String[] args) throws InterruptedException{
    //创建一个ScheduledThreadPoolExecutor对象
    ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
    //计划在某段时间后运行
    System.out.println("Current Time = "+new Date());
    for(int i=0; i<3; i++){
      Thread.sleep(1000);
      WorkerThread worker = new WorkerThread("do heavy processing");
      //创建并执行在给定延迟后启用的单次操作。
      // scheduledThreadPool.schedule(worker, 10, TimeUnit.SECONDS);
      //ScheduledExecutorService scheduleAtFixedRate方法来安排任务在初始延迟后运行，然后在给定的时间段内运行。 将延迟视为两个任务开始之间的差异
      // scheduledThreadPool.scheduleAtFixedRate(worker, 0, 10, TimeUnit.SECONDS);
      //scheduleWithFixedDelay方法可用于以初始延迟启动周期性执行，然后以给定延迟执行。 延迟时间是线程完成执行的时间。将延迟视为一个任务结束与下一个任务开始之间的差异
      scheduledThreadPool.scheduleWithFixedDelay(worker, 0, 2, TimeUnit.SECONDS);
    }
    //添加一些延迟让调度程序产生一些线程
    Thread.sleep(30000);
    System.out.println("Current Time = "+new Date());
    //关闭线程池
    scheduledThreadPool.shutdown();
    while(!scheduledThreadPool.isTerminated()){
      //等待所有任务完成
    }
    System.out.println("Finished all threads");
  }


}
