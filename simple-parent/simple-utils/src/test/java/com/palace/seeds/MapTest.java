package com.palace.seeds;

import java.util.HashMap;
import java.util.Map;

import com.palace.seeds.util.RandomMsg;

public class MapTest {

	static Map<String,String> map  =  new HashMap<String,String>();
	static public synchronized  void putMap(String key ,String val){
		map.put(key, val);
	}
	static public synchronized void remove(String key){
		map.remove(key);
	}
	public static String str1="";
	public void run(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<20;i++){
					String str= RandomMsg.nextStr();
					if(i==10){
						str1=str;
					}
					putMap(str, RandomMsg.nextStr());
				}
				map.entrySet().iterator();
				while(true){
					for(Map.Entry<String, String> entry : map.entrySet()){
						System.out.println("size is "+map.size()+":::key is "+entry.getKey()+":::val is "+entry.getValue());
					}
					try {
						Thread.currentThread().sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public void run2(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				 if(map.size()>0){
					 map.remove(str1);
				 }
			}
		}).start();
	}
	
	public static void main(String[] args) {
		 
		
		
		MapTest mt = new MapTest(); 
		 mt.run();
		 try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 mt.run2();
	}
}
