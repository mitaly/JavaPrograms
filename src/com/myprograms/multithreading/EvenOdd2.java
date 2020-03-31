package com.myprograms.multithreading;

public class EvenOdd2 {
	public static void main(String[] args) {
		EvenOddPrinter2 odd = new EvenOddPrinter2(1);
		EvenOddPrinter2 even = new EvenOddPrinter2(0);

		Thread oddThread = new Thread(odd, "Odd");
		Thread evenThread = new Thread(even, "Even");

		oddThread.start();
		evenThread.start();
	}
}

class EvenOddPrinter2 implements Runnable {
	static int count = 1;
	int MAX = 10;
	int remainder;

	static Object object = new Object();

	EvenOddPrinter2(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {
		while (count < MAX) {
			synchronized (object) {
				while (count % 2 != remainder) {
					try {
					object.wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : " + count);
				count++;
				object.notifyAll();
			}
		}
	}
}
