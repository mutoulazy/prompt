package prompt.timedtask;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 并行
 * 基于线程池的定时任务调度：ScheduledExecutorService
 */
public class ScheduledExecutorServiceDemo implements Runnable {

  @Override
  public void run() {
    System.out.println("execute time is :" + new Date());
  }

  public static void main(String[] args) {
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
    scheduledExecutorService
        .scheduleAtFixedRate(new ScheduledExecutorServiceDemo(), 1000, 2000, TimeUnit.MILLISECONDS);
  }
}
