package prompt.timedtask;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzDemo {

  public static void main(String[] args) throws SchedulerException {
    JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("myJob", "myGroup")
        .usingJobData("name", "xiaoming").build();

    Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTriggrtName", "myTriggrtGroup")
        .withSchedule(
            SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
        .startNow().build();

    SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    Scheduler scheduler = schedulerFactory.getScheduler();
    scheduler.scheduleJob(jobDetail, trigger);
    scheduler.start();
  }
}
