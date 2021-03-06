package com.myprograms.multithreading;

import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ThreadSafe {
	ThreadLocal<String> myThreadLocalObj = new ThreadLocal<String>();
	String nonThreadSafe;

	public static void main(String[] args) throws InterruptedException {
		// each thread will have it's own copy of this variable
		ThreadSafe thSafe = new ThreadSafe();
		thSafe.threadLocal();

		// UsingAtomicLongArray
//		UsingAtomicLongArray arr = new UsingAtomicLongArray();
//		arr.setAtIndex(0, 20000);
//		System.out.println(arr.get(0));

		// Creating synchronized map
//		SortedMap<Integer, String> map = new TreeMap<Integer, String>();
//		Map<Integer, String> synchronizedMap = Collections.synchronizedSortedMap(map);
		
	
		//Intrinsic locking using synchronized statement
//		IntrinsicLockingSynchronizedDemo intrinsicSyn = new IntrinsicLockingSynchronizedDemo();
//		intrinsicSyn.inrement();
//		System.out.println(intrinsicSyn.get());
		
		//Extrinsic locking using synchronized statement
//		ExtrinsicLockingSynchronizedDemo extrinsicSyn = new ExtrinsicLockingSynchronizedDemo();
//		extrinsicSyn.increment();
//		System.out.println(extrinsicSyn.get());
		
		//ReentrantLock
//		ReentrantLockDemo reentrantDemo = new ReentrantLockDemo();
//		reentrantDemo.increment();
//		System.out.println(reentrantDemo.get());
		
		//ReentrantReadWRiteLock
//		ReentrantReadWriteLockDemo readWriteDemo = new ReentrantReadWriteLockDemo();
//		readWriteDemo.increment();
//		readWriteDemo.increment();
//		System.out.println(readWriteDemo.get());
	}

	private void threadLocal() throws InterruptedException {
		nonThreadSafe = "mitaly";
		myThreadLocalObj.set("hello world");

		Thread th1 = new Thread(() -> {
			myThreadLocalObj.set("Changed by thread 1");
			nonThreadSafe = "hi! this is thread 1";
		});
		Thread th2 = new Thread(() -> {
			myThreadLocalObj.set("changed by thread 2");
			nonThreadSafe = "hi! this is thread 2";
		});
		th1.start();
		th2.start();
		//will throw InterruptedException
		th1.start();//

		Thread.sleep(2000);
		// main thread has "hello world" value of threadlocal variable
		System.out.println(myThreadLocalObj.get());
		// thread 2 will modify the nonThreadSafe variable
		System.out.println(nonThreadSafe);
	}
}

class IntrinsicLockingSynchronizedDemo{
	int counter = 0;
	
	void inrement() {
		synchronized(this) {
			counter++;
		}
	}
	
	int get() {
		return counter;
	}
}

class ExtrinsicLockingSynchronizedDemo{
	int counter = 0;
	
	private final Object lock = new Object();
	
	void increment() {
		synchronized(lock) {
			counter++;
		}
	}
	
	int get() {
		return counter;
	}
}

class ReentrantLockDemo{
	int counter = 0;
	private final ReentrantLock reentrantLock = new ReentrantLock();
	
	void increment() {
		reentrantLock.lock();
		try {
			counter++;
		}finally{
			reentrantLock.unlock();
		}
	}

	int get() {
		return counter;
	}
}

class ReentrantReadWriteLockDemo{
	int counter = 0;
	private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private final ReadLock readLock = readWriteLock.readLock();
	private final WriteLock writeLock = readWriteLock.writeLock();
	
	void increment() {
		writeLock.lock();
		try {
			counter++;
		}finally {
			writeLock.unlock();
		}
	}
	
	int get() {
		readLock.lock();
		try {
			return counter;
		}finally {
			readLock.unlock();
		}
	}
}
class UsingAtomicLongArray {
	private AtomicLongArray atomic = new AtomicLongArray(20);

	public UsingAtomicLongArray() {
		atomic.set(0, 12);
		atomic.set(1, 3);
		atomic.set(2, 5);
		atomic.set(3, 90);
	}

	public void setAtIndex(int index, long elem) {
		atomic.getAndSet(index, elem);
	}

	public long get(int index) {
		return atomic.get(index);
	}
}