package com.palace.seeds.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	ReentrantLock lock = new ReentrantLock();
	int a=10;
	
	public void test(){
		while(true){
			lock.lock();
			a=a+100;
			try {
				Thread.currentThread().sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"="+a);
			lock.unlock();
		}
	}
	
	
	
	public static void main(String[] args) {
		final ReentrantLockTest test=new ReentrantLockTest();
		System.out.println(ReentrantLockTest.class.getClassLoader());
		new Thread(new Runnable() {
			@Override
			public void run() {
				test.test();
			}
		},"first").start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				test.test();
			}
		},"second").start();
		
/*		new Thread(new Runnable() {
			@Override
			public void run() {
				test.test();
			}
		},"three").start();*/
	}
}
