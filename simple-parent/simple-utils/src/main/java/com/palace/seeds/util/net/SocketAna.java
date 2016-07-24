package com.palace.seeds.util.net;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketAna {

	public static void main(String[] args) {
		// new SocketAna().server();
		new SocketAna().threadTest();
	}
	public void server(){
		try {
			ServerSocket ss = new ServerSocket(5106);
			ss.accept();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void threadTest(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}).start();
	}
	
}

