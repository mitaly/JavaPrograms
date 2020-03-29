package com.myprograms.multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException{
		PC pc = new PC();
		
		Thread producer = new Thread(() ->  {
			try {
				pc.produce();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread consumer = new Thread(() -> {
			try {
				pc.consume();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		producer.start();
		consumer.start();
		
		producer.join();
		consumer.join();
	}
}

class PC{
	private static final int MAX_SIZE = 10;
	private static List<Integer> list = new ArrayList<Integer>();
	
	public PC() {
		
	}
	
	void produce() throws InterruptedException{
		int item = 0;
		
		while(true) {
			synchronized (this) {
				while(list.size() == MAX_SIZE) {
					wait();
				}
				System.out.println("Produced "+item);
				list.add(item++);
				notify();
				Thread.sleep(1000);
			}
		}
	}
	
	void consume() throws InterruptedException{
		while(true) {
			synchronized (this) {
				while(list.isEmpty()) {
					wait();
				}
				int itemRemoved = list.remove(0);
				System.out.println("consumed "+itemRemoved);
				notify();
				Thread.sleep(1000);
			}
		}
	}
}