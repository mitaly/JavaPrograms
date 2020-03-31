package com.myprograms.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	public static void main(String[] args) {
		SemaphoreUtill util = new SemaphoreUtill();
		
		Thread inc = new Thread(util, "Inc");
		Thread dec = new Thread(util, "Dec");
		
		dec.start();
		inc.start();
	}
}

class SemaphoreUtill implements Runnable {
	Semaphore semaphore = new Semaphore(1);
	static int count = 5;

	@Override
	public void run() {
		try {
			if (Thread.currentThread().getName().equals("Dec")) {
				semaphore.acquire();
				while (count > 0) {
					System.out.println("Dec:" + count);
					count--;
					Thread.sleep(1000);
				}
				semaphore.release();
			} else {
				semaphore.acquire();
				while(count < 5) {
					System.out.println("Inc:"+count);
					count++;
					Thread.sleep(1000);
				}
				semaphore.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
