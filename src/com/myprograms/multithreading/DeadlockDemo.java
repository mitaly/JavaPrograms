package com.myprograms.multithreading;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class DeadlockDemo {
	private static ScheduledFuture scheduledFuture;
	
	public static void main(String[] args) {
		final String resource1 = "resource 1";
		final String resource2 = "resource 2";

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		scheduledFuture = executor.scheduleAtFixedRate(() -> {
			ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
			long[] deadlockedThreadIds = threadMXBean.findDeadlockedThreads();
			if (deadlockedThreadIds != null && deadlockedThreadIds.length > 0) {
				ThreadInfo[] threadInfoArr = threadMXBean.getThreadInfo(deadlockedThreadIds);
				
				for (ThreadInfo info : threadInfoArr) {
					System.out.println(info.getThreadName());
				}
				
				scheduledFuture.cancel(true);
			}

		}, 0, 1000, TimeUnit.MILLISECONDS);

		Thread thread1 = new Thread() {
			@Override
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 1 acquired lock on resource 1");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Thread 1 waiting for resource 2");
					synchronized (resource2) {
						System.out.println("Thread 1 acquired lock on resource 2");
					}
				}
			}
		};

		Thread thread2 = new Thread() {
			@Override
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 2 acquired lock on resource 2");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Thread 2 waiting for resource 1");
					synchronized (resource1) {
						System.out.println("Thread 2 acquired lock on resource 1");
					}
				}
			}
		};
		thread1.start();
		thread2.start();
	}

}
