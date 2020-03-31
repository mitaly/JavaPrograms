package com.myprograms.multithreading;

public class EvenOdd {
	public static void main(String[] args) throws InterruptedException{
		EvenOddPrinter printer = new EvenOddPrinter();
		
		Thread even = new Thread(() -> {
			try {
				printer.odd();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread odd = new Thread(() -> {
			try {
				printer.even();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		odd.start();
		even.start();
		
		odd.join();
		even.join();
	}
}

class EvenOddPrinter{
	boolean odd = true;
	int count = 1;
	int max = 10;
	
	void even() throws InterruptedException{
		synchronized (this) {
			while(count < max) {
				while(odd) {
					wait();
				}
				System.out.println("even thread:"+count++);
				odd = true;
				notify();
				Thread.sleep(500);
			}
		}
	}
	
	void odd() throws InterruptedException{
		synchronized (this) {
			while(count < max) {
				while(!odd) {
					wait();
				}
				System.out.println("odd thread:"+count++);
				odd = false;
				notify();
				Thread.sleep(500);
			}
		}
	}
}