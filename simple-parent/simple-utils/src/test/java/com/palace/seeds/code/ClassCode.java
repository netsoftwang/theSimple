package com.palace.seeds.code;

public class ClassCode {

	
	public static void main(String[] args) {
		
	}
	
	public void test(String name,int age){
		
		int i=0;
		int j=i+123;
		System.out.println(i+j);
	}
	public void virtualMethod(String para){
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("the inner method");
			}
		}).start();
	}
	class inner{
		String add="aaa";
		public void  innerMethod(){
			System.out.println("hello");
		}
	}
}
