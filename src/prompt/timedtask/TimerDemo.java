package prompt.timedtask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 串行
 * Timer 原生定时工具
 */
public class TimerDemo {

  public static void main(String[] args) {
    Timer timer = new Timer();
    Calendar calendar = Calendar.getInstance();
    // timer.schedule(new MyTask(), calendar.getTime(), 1000);
    timer.scheduleAtFixedRate(new MyTask(), calendar.getTime(), 1000);
  }

}

class MyTask extends TimerTask {

  @Override
  public void run() {
    System.out.println("execute time is :" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        .format(this.scheduledExecutionTime()));
    try {
      Thread.sleep(2000);
    }catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}