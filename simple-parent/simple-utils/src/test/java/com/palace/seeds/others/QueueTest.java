package com.palace.seeds.others;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReentrantLock;

import com.palace.seeds.util.RandomVal;

public class QueueTest {

	LinkedBlockingDeque<String> queue= new LinkedBlockingDeque<String>();
	public void run(){
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String str=System.currentTimeMillis()+"_"+RandomVal.nextStr();
					queue.add(str);
					System.out.println(str);
				}
			}
		}).start();
	}
	
	/*
	 * 方法阻塞线程
	 * 多个线程持有一个引用，引用的方法中存在多个方法可以阻塞线程
	 * 
	 * 如果要阻塞某个线程则在方法中调用对某个实例的监视器的等待，则当前线程阻塞等待，
	 * 如果多个线程公用同一个监视器，这其中一个程序修改监视器的状态，则另一个线程会受到影响
	 */
	
	public void add(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						queue.take();
						Thread.sleep(3000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String str=System.currentTimeMillis()+"_"+RandomVal.nextStr();
					queue.add(str);
					System.out.println(str);
				}
			}
		}).start();
	}
	
	public void print(){
		ReentrantLock  lock = new ReentrantLock();
	}

	
	
}
