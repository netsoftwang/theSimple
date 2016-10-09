package com.palace.seeds.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {

	
	public static ThreadLocal<String> threadLocal=new ThreadLocal<String>();
	public static void main(String[] args) {
		threadLocal.set("asdas");
		
		ArrayBlockingQueue<String> queue=new ArrayBlockingQueue<String>(100);
		System.out.println("d");
	}
}
