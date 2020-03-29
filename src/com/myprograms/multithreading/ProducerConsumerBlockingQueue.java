package com.myprograms.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerBlockingQueue {
	public static void main(String[] args) {
		PC1 pc = new PC1();

		Thread producer = new Thread(() -> {
			try {
				pc.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread consumer = new Thread(() -> {
			try {
				pc.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		producer.start();
		consumer.start();
	}
}

class PC1 {
	private final int MAX_SIZE = 10;
	private BlockingQueue<Integer> bq = new LinkedBlockingQueue<Integer>(MAX_SIZE);

	void produce() throws InterruptedException {
		int item = 0;
		while (true) {
			System.out.println("Produced " + item);
			bq.put(item++);
			Thread.sleep(1000);
		}
	}

	void consume() throws InterruptedException {
		while (true) {
			int itemRemoved = bq.take();
			System.out.println("Consumed " + itemRemoved);
			Thread.sleep(1000);
		}
	}
}