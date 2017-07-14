package com.demo;

import java.util.ArrayList;
import java.util.List;

public class Resource {
	private static List<Integer> resources = new ArrayList<>();
	
	public synchronized static void getResource(String job) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
			boolean toDelete = false;
			if(resources.size() > 10) {
				toDelete = true;
			}
			for (int i = 0;i < 10;i++) {
				
				if(!toDelete) {
					System.out.println("adding "+i);
					resources.add(i);
				}else {
					System.out.println("deleting"+i);
					resources.remove(i);
				}
				Thread.sleep(2000);
		      }	
			System.out.println("Size of resource "+ resources.size() );
		}	
}
