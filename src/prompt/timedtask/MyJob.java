package prompt.timedtask;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    System.out.println(
        "execute time is : " + new Date() + "," + jobExecutionContext.getJobDetail().getJobDataMap()
            .get("name"));
  }
}
