package practice.thread.std14;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorDemo {

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 10; i++) {
      WorkerThread thread = new WorkerThread("" + i);
      executor.execute(thread);
    }
    // 终止线程池
    executor.shutdown();
    while (!executor.isTerminated()) {
    }
    System.out.println("Finished all threads");
  }

  static public class WorkerThread extends Thread {
    private String command;

    public WorkerThread(String command) {
      this.command = command;
    }

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
      processCommand();
      System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    @Override
    public String toString() {
      return "WorkerThread{" +
          "command='" + command + '\'' +
          '}';
    }
  }
}
