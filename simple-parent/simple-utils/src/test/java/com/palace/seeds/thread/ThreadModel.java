package com.palace.seeds.thread;

public class ThreadModel {

	public synchronized  void set(String name){
		System.out.println("set name:"+name);
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("set name end");
	}
	
	public synchronized String get(){
			System.out.println("get name begin");
			 System.out.println("get name end");
			 return "";
	}
}
