package com.myprograms.multithreading;

public class SequenceUsing3Threads {
	public static void main(String[] args) {
		Thread th1 = new Thread(new SequenceUtil(1), "Th1");
		Thread th2 = new Thread(new SequenceUtil(2), "Th2");
		Thread th3 = new Thread(new SequenceUtil(0), "Th3");
		
		th1.start();
		th2.start();
		th3.start();
	}
}

class SequenceUtil implements Runnable{
	static int count = 1;
	int MAX = 10;
	int remainder;
	static Object lock = new Object();
	
	public SequenceUtil(int remainder) {
		this.remainder = remainder;
	}
	@Override
	public void run() {
		while(count < MAX) {
			try {
				synchronized (lock) {
					while(count%3 != remainder) {
						lock.wait();
					}
					System.out.println(Thread.currentThread().getName()+" : "+count++);
					lock.notifyAll();
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}