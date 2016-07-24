package com.palace.seeds.thread;

public class ThreadSychTest {

	
	
	
	public static void main(String[] args) {
		final ThreadModel tm =new ThreadModel();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread 2 begin");
				tm.get();
				try {
					Thread.currentThread().sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tm.get();
			}
		}).start();
		
		
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				 System.out.println("thread1 begin");
				 tm.set("name");
				 
				 try {
						Thread.currentThread().sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
				 System.out.println("thread1 begin");
				 tm.set("name");
			}
			
			
		}).start();
		
	}
	
}
