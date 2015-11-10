package com.palace.seeds;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

import com.palace.seeds.util.RandomVal;
import com.palace.seeds.util.User;

public class MapTest {
	
	public static void main(String[] args) {
		
		

	}
	
	
	Map<String,User>  currMap = new ConcurrentHashMap<String,User>();
	boolean flag=false;
	public void run5(){
		
		
		
		
	}

	
	//----------------HashTable----------------------------
		public void threadRun1(){
			final MapTest mt = new MapTest(); 
			new Thread(new Runnable() {
				@Override
				public void run() {
					mt.run3();
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					mt.run4();
				}
			}).start();
		}
		
	/**
	 * HashTable是线程安全的。
	 * 如果在迭代的时候修改HashTable中的内容是否会发生异常，
	 * 他的安全域是怎么样，如果我要迭代其中的内容，整个迭代的循环周期都是线程安全的么
	 * 
	 * 结果是：在迭代期间整个while循环是不同步的，HashTable的迭代安全只是HashTable各自方法上的安全
	 */
	Object obj = new Object();
	String[] keyArr = new String[20];
	Map<String,User> hashTable=new Hashtable<String,User>();
	public void run3(){
		for(int i=0;i<keyArr.length;i++){
			String key = RandomVal.nextStr();
			keyArr[i]= key;
			hashTable.put(key,new User(key));
		}
		
		Iterator<Entry<String,User>> iterator=  hashTable.entrySet().iterator();
		synchronized (obj) {
			while(iterator.hasNext()){
				Entry<String,User> entry = iterator.next();
				System.out.println(entry.getValue().toString());
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public void run4(){
		
		synchronized (obj) {
			for(int i =0;i<keyArr.length;i++){
				try {
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String key = keyArr[i];
				if(key !=null){
					User user =  hashTable.get(key);
					if(user!=null){
						System.out.println("    run4 before:::"+user.toString());
						user.setName(RandomVal.nextStr());
						System.out.println("    run4 after :::"+user.toString());
					}
				}
			}
		}
	}
	

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
					String str= RandomVal.nextStr();
					if(i==10){
						str1=str;
					}
					putMap(str, RandomVal.nextStr());
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
	

}
