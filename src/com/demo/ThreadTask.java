package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ThreadTask implements Job{

	private static List<Integer> resources = new ArrayList<>();
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
			try {
				getResource(arg0.getTrigger().getKey().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Threw exception "+ e.getMessage());
			}
	}
	

	
	public synchronized static void getResource(String trigger) throws Exception {
			
		if("trigger1".equals(trigger)) {
			throw new Exception(trigger);
		}
			
				for (int i = 0;i < 10;i++) {
				System.out.println(Thread.currentThread().getName()+"---"+trigger);
				Thread.sleep(1000);
		      }	
		}	
	
}
