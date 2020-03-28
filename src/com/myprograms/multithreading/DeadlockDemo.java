package com.myprograms.multithreading;

public class DeadlockDemo {
	public static void main(String[] args) {
		final String resource1 = "resource 1";
		final String resource2 = "resource 2";

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
