package com.demo;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class ThreadSync {
	public static String SECONDS = "";
	public static String MINUTES = "34";
	public static String HOUR = "8";
	public static String DAY_OF_MONTH = "*";
	public static String MONTH = "*";
	public static String DAY_OF_WEEK = "?";
	public static String YEAR = "*";
	
	public static void main(String [] args) {
		SchedulerFactory sf = new StdSchedulerFactory();
		
		try {
			Scheduler scheduler = sf.getScheduler();
			JobDetail job = JobBuilder.newJob(ThreadTask.class)
				      .withIdentity("job1", "group1")
				      .storeDurably()
				      .build();
			Trigger trigger1 = TriggerBuilder.newTrigger()
				      .withIdentity("trigger1", "group1")
				      .startNow()
				      .forJob(job)
				      .withSchedule(CronScheduleBuilder.cronSchedule("0 "+MINUTES+" "+HOUR+" "+DAY_OF_MONTH+" "+MONTH+" "+DAY_OF_WEEK))
				      .build();
			Trigger trigger2 = TriggerBuilder.newTrigger()
				      .withIdentity("trigger2", "group1")
				      .startNow()
				      .forJob(job)
				      .withSchedule(CronScheduleBuilder.cronSchedule("2 "+MINUTES+" "+HOUR+" "+DAY_OF_MONTH+" "+MONTH+" "+DAY_OF_WEEK))
				      .build();
			Trigger trigger3 = TriggerBuilder.newTrigger()
				      .withIdentity("trigger3", "group1")
				      .startNow()
				      .forJob(job)
				      .withSchedule(CronScheduleBuilder.cronSchedule("2 "+MINUTES+" "+HOUR+" "+DAY_OF_MONTH+" "+MONTH+" "+DAY_OF_WEEK))
				      .build();
			Trigger trigger4 = TriggerBuilder.newTrigger()
				      .withIdentity("trigger4", "group1")
				      .startNow()
				      .forJob(job)
				      .withSchedule(CronScheduleBuilder.cronSchedule("3 "+MINUTES+" "+HOUR+" "+DAY_OF_MONTH+" "+MONTH+" "+DAY_OF_WEEK))
				      .build();
			
			scheduler.addJob(job, true);
			scheduler.scheduleJob(trigger1);
			scheduler.scheduleJob(trigger2);	
			scheduler.scheduleJob(trigger3);
			scheduler.scheduleJob(trigger4);	
		
			
			
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
